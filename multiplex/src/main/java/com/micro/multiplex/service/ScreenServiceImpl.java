package com.micro.multiplex.service;

import java.util.ArrayList;

import java.util.List;



import org.springframework.stereotype.Service;

import com.micro.multiplex.dao.AllotedMoviesRepository;
import com.micro.multiplex.dao.MultiplexRepository;
import com.micro.multiplex.dao.ScreenRepository;
import com.micro.multiplex.document.AllotedMovies;
import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.document.ScreenDetail;
import com.micro.multiplex.dto.MultiplexDetailDto;
import com.micro.multiplex.dto.RegisterMultiplexDto;
import com.micro.multiplex.dto.ScreenDetailsDto;

@Service
public class ScreenServiceImpl implements ScreenService {

	private ScreenRepository screenRepository;
	private MultiplexRepository repository;
	private AllotedMoviesRepository allotedMoviesRepository;
	
	public ScreenServiceImpl(ScreenRepository screenRepository,MultiplexRepository repository,AllotedMoviesRepository allotedMoviesRepository) {
		this.screenRepository=screenRepository;
		this.repository=repository;
		this.allotedMoviesRepository=allotedMoviesRepository;
	}
	//ADD A SCREEN FOR A MULTIPLEX
	public ScreenDetailsDto addScreen(String screenName,String multiplexId) {
		MultiplexDetail multiplexDetail =  this.repository.findById(multiplexId).orElse(null);
		List<ScreenDetail> getAllScreens=(List<ScreenDetail>) this.screenRepository.findByMultiplexId(multiplexId);
		ScreenDetailsDto  screenDetailsDto=new ScreenDetailsDto();
		if(getAllScreens.size()<multiplexDetail.getNumberOfScreens())
		{
			//convert to Document
		ScreenDetail screenDetail = new ScreenDetail(null, 
				   screenName,
				   multiplexId); 
		screenDetail= this.screenRepository.save(screenDetail);
        // convert Document->Dto
		screenDetailsDto = new ScreenDetailsDto (screenDetail.getScreenId(),screenDetail.getScreenName(),screenDetail.getMultiplexId());
        
		}
		else {
			return null;
		}
		return screenDetailsDto;
	}
	//GET ALL SCREEN DETAILS FOR A SINGLE MULTIPLEX
	public List<ScreenDetail> getAllScreens(String multiplexId) {
		List<ScreenDetail> getAllScreens=(List<ScreenDetail>) this.screenRepository.findByMultiplexId(multiplexId);

		return getAllScreens;
	}
	//GET ALL AVAILABLE SCREEN  FOR A SINGLE MULTIPLEX AFTER ALLOCATION
	@Override
	public List<ScreenDetail> getAvailableScreens(String multiplexId) {
		List<ScreenDetail> screenDetails=(List<ScreenDetail>) this.screenRepository.findByMultiplexId(multiplexId);
		List<ScreenDetail> screensAvailable=new ArrayList<ScreenDetail>();	
		List<AllotedMovies> allotedMovies=this.allotedMoviesRepository.findByMultiplexId(multiplexId);
		if(allotedMovies.isEmpty()) {
			return screenDetails;
		}
		else {
			for(AllotedMovies am:allotedMovies) {
				for(ScreenDetail sd:screenDetails) {
				   if(sd.getScreenId().equals(am.getScreenId())) {
					System.out.println("Screen allocated");
				   }
				   else {
					   screensAvailable.add(sd);
				   }
				}
			}
		}
	return screensAvailable;
	}
}
