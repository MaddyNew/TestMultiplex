package com.micro.multiplex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.multiplex.dao.MultiplexRepository;
import com.micro.multiplex.dao.ScreenRepository;
import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.document.ScreenDetail;
import com.micro.multiplex.dto.MultiplexDetailDto;
import com.micro.multiplex.dto.RegisterMultiplexDto;
import com.micro.multiplex.dto.ScreenDetailsDto;
import com.micro.multiplex.dto.UpdateDetailDto;
@Service
public class MultiplexServiceImpl implements MultiplexService {
	private MultiplexRepository repository;
	
	
	public MultiplexServiceImpl(MultiplexRepository repository) {
		this.repository = repository;
	}
	
	//ADD A MULTIPLEX
	@Override
	public MultiplexDetailDto register(RegisterMultiplexDto registerDto) {
		//covert dto->Document
		MultiplexDetail multiplexDetail = new MultiplexDetail(null, 
				   registerDto.getMultiplexName(),
				   registerDto.getAddress(), 
				   registerDto.getNumberOfScreens(),
				   registerDto.getPhotoPath()); 
        multiplexDetail = this.repository.save(multiplexDetail);
        // convert Document->Dto
        MultiplexDetailDto  multiplexDetailDto = new MultiplexDetailDto (multiplexDetail.getMultiplexId(), 
		multiplexDetail.getMultiplexName(), 
		multiplexDetail.getAddress(), 
		multiplexDetail.getNumberOfScreens(),
		multiplexDetail.getPhotoPath());
        return multiplexDetailDto;
	}
	
	//GET LIST OF ALL MULTIPLEXES
	@Override
	public List<MultiplexDetail> getAllMultiplexes() {
		List<MultiplexDetail> getAllMultiplexes=(List<MultiplexDetail>) this.repository.findAll();
		return getAllMultiplexes;
	}
	
	//GET A MULTIPLEX BASED ON ITS ID
	@Override
	public MultiplexDetailDto getMultiplexDetail(String multiplexId) {
		MultiplexDetail multiplexDetail =  this.repository.findById(multiplexId).orElse(null);
		if(multiplexDetail != null) {
			MultiplexDetailDto multiplexDetailDto= new MultiplexDetailDto(multiplexDetail.getMultiplexId(), 
					multiplexDetail.getMultiplexName(), 
					multiplexDetail.getAddress(), 
					multiplexDetail.getNumberOfScreens(),
					multiplexDetail.getPhotoPath());
			return multiplexDetailDto;
		}
		return null;
	}
	
	//DELETE A MULTIPLEX
	@Override
	public void deleteMultiplex(String multiplexId) {
		MultiplexDetail multiplexDetail =  this.repository.findById(multiplexId).orElse(null);
		if(multiplexDetail != null) {
			repository.deleteById(multiplexId);	
		}
	}
	
	//UPDATE A MULTIPLEX
	@Override
	public MultiplexDetailDto updateMultiplexDetail(String multiplexId, UpdateDetailDto updateDto) {
		MultiplexDetail multiplexDetail =  this.repository.findById(multiplexId).orElse(null);
		if(multiplexDetail != null) {
			multiplexDetail.setMultiplexId(multiplexId);
			multiplexDetail.setMultiplexName(updateDto.getMultiplexName());
			multiplexDetail.setAddress(updateDto.getAddress());
			multiplexDetail.setNumberOfScreens(updateDto.getNumberOfScreens());
			multiplexDetail.setPhotoPath(updateDto.getPhotoPath());
			
			multiplexDetail = this.repository.save(multiplexDetail);
			  MultiplexDetailDto  multiplexDetailDto = new MultiplexDetailDto (multiplexDetail.getMultiplexId(), 
						multiplexDetail.getMultiplexName(), 
						multiplexDetail.getAddress(), 
						multiplexDetail.getNumberOfScreens(),
						multiplexDetail.getPhotoPath());
				        return multiplexDetailDto;
		}
		return null;
	}
	

	
	
	
}

