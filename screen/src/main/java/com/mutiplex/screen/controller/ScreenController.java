package com.mutiplex.screen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutiplex.screen.dto.MultiplexDetailDto;
import com.mutiplex.screen.dto.ScreenDetailDto;
import com.mutiplex.screen.dto.ScreenDto;
import com.mutiplex.screen.service.ScreenService;


@RestController
public class ScreenController {
	
	private ScreenService screenService;
	
	public ScreenController(ScreenService screenService) {
		this.screenService=screenService;
	}
	
	@PostMapping("/register/{mulitplexId}")
	public ResponseEntity<ScreenDetailDto> register(@RequestBody ScreenDto screenDto,@PathVariable ("multiplexId") String multiplexId) {
		//MultiplexDetailDto multiplexDetailDto = this.multiplexService.register(registerDto);
		ScreenDetailDto screenDetailDto= this.screenService.register(screenDto, multiplexId);
		ResponseEntity<ScreenDetailDto> response = 
				new ResponseEntity<ScreenDetailDto>(screenDetailDto,HttpStatus.OK);
		return response;
	}
}
