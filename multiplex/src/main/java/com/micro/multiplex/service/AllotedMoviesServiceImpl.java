package com.micro.multiplex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.micro.multiplex.dao.AllotedMoviesRepository;
import com.micro.multiplex.dao.MultiplexRepository;
import com.micro.multiplex.document.AllotedMovies;
import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.dto.AddAllotmentDto;
import com.micro.multiplex.dto.AllotmentDetailsDto;
import com.micro.multiplex.dto.MultiplexDetailDto;
@Service
public class AllotedMoviesServiceImpl implements AllotedMoviesService {
	private AllotedMoviesRepository allotedMoviesRepository;
	private MultiplexRepository repository;
	
	
	public AllotedMoviesServiceImpl(AllotedMoviesRepository allotedMoviesRepository,MultiplexRepository repository) {
		this.allotedMoviesRepository=allotedMoviesRepository;
		this.repository=repository;
	}
	//ADD MOVIE ALLOTMENT 
	public AllotmentDetailsDto addAllotment(AddAllotmentDto addAllotmentDto) {
		AllotedMovies allotedMovies = new AllotedMovies(null, 
				   addAllotmentDto.getMovieId(),
				   addAllotmentDto.getMultiplexId(),
				   addAllotmentDto.getScreenId());
		
		allotedMovies = this.allotedMoviesRepository.save(allotedMovies);
		
     // convert Document->Dto
		AllotmentDetailsDto  allotmentDetailsDto = new AllotmentDetailsDto (allotedMovies.getAllotmentId(),
				allotedMovies.getMovieId(),
				allotedMovies.getMultiplexId(),
				allotedMovies.getScreenId());
     return allotmentDetailsDto;
		
	}
	@Override
	//GET ALL MULTIPLEXES FOR A MOVIE
	public List<MultiplexDetail> getMultiplexMovieDetails(String movieId) {
		
		List<AllotedMovies> allotedMovies =  this.allotedMoviesRepository.findByMovieId(movieId);
		
		List<MultiplexDetail> multiplexes=new ArrayList<MultiplexDetail>();
		for(AllotedMovies ls:allotedMovies) {
			MultiplexDetail multiplexes1 = this.repository.findById(ls.getMultiplexId()).orElse(null);
			multiplexes.add(multiplexes1);
		}
		return multiplexes;
		
	}

}
