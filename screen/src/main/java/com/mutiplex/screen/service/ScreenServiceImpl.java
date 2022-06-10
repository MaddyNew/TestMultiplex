package com.mutiplex.screen.service;

import com.mutiplex.screen.dao.ScreenServiceRepository;
import com.mutiplex.screen.document.ScreenDetails;
import com.mutiplex.screen.dto.ScreenDetailDto;
import com.mutiplex.screen.dto.ScreenDto;

public class ScreenServiceImpl implements ScreenService {
	
	private ScreenServiceRepository repository;
	
	public ScreenServiceImpl(ScreenServiceRepository repository) {
		this.repository = repository;
	}

	@Override
	public ScreenDetailDto register(ScreenDto screenDto, String multiplexId) {
		
		// Dto->Document
				ScreenDetails screen = new ScreenDetails(null, 
									   screenDto.getScreenName(),
									   multiplexId);
				
				screen = this.repository.save(screen);
				// UserDetailDto userDetailDto = this.restTemplate.getForObject(USER_URL + "/get/" + userId, UserDetailDto.class);
				ScreenDetailDto screenDetailDto = this.proxy.getMultiplexDetail(multiplexId).getBody();
				
				ScreenDetailDto screenDetailDto = new ScreenDetailDto(screen.getScreenId(), screen.getScreenName(),screen.getMultiplexId());
				
						
				return screenDetailDto;
		
		
		
	}

}
