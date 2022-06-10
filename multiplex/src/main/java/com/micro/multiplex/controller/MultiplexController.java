package com.micro.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.document.ScreenDetail;
import com.micro.multiplex.dto.AddAllotmentDto;
import com.micro.multiplex.dto.AllotmentDetailsDto;
import com.micro.multiplex.dto.MultiplexDetailDto;
import com.micro.multiplex.dto.RegisterMultiplexDto;
import com.micro.multiplex.dto.ScreenDetailsDto;
import com.micro.multiplex.dto.UpdateDetailDto;
import com.micro.multiplex.service.AllotedMoviesService;
import com.micro.multiplex.service.MultiplexService;
import com.micro.multiplex.service.ScreenService;


@RestController
@RequestMapping("/api/multiplex")
//@CrossOrigin("*")
public class MultiplexController {
	
	private MultiplexService multiplexService;
	private ScreenService screenService;
	private AllotedMoviesService allotedMoviesService;
	
	@Autowired
	public MultiplexController(MultiplexService multiplexService,ScreenService screenService,AllotedMoviesService allotedMoviesService) {
		this.multiplexService = multiplexService;
		this.screenService=screenService;
		this.allotedMoviesService=allotedMoviesService;
	}
	@PostMapping("/register")
	public ResponseEntity<MultiplexDetailDto> register(@RequestBody RegisterMultiplexDto registerDto) {
		MultiplexDetailDto multiplexDetailDto = this.multiplexService.register(registerDto);
		ResponseEntity<MultiplexDetailDto> response = 
				new ResponseEntity<MultiplexDetailDto>(multiplexDetailDto,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAllMultiplexes")
	public ResponseEntity<List<MultiplexDetail>> getAllMultiplexes() {
		List<MultiplexDetail> getMultiplexes=this.multiplexService.getAllMultiplexes();
		ResponseEntity<List<MultiplexDetail>> response = 
				new ResponseEntity<List<MultiplexDetail>>(getMultiplexes,HttpStatus.OK);
		return response;
	}
	@GetMapping("/get/{multiplexId}")
	public ResponseEntity<MultiplexDetailDto> getMultiplexDetail(@PathVariable("multiplexId")String multiplexId) {
		MultiplexDetailDto multiplexDetailDto =  this.multiplexService.getMultiplexDetail(multiplexId);
	
		ResponseEntity<MultiplexDetailDto> response = 
				new ResponseEntity<MultiplexDetailDto>(multiplexDetailDto,HttpStatus.OK);
		return response;
		
	}
	@DeleteMapping("/delete/{multiplexId}")
	public void deleteMultiplex(@PathVariable("multiplexId")String multiplexId) {
	
	this.multiplexService.deleteMultiplex(multiplexId);

	}
	
	@PutMapping("/update/{multiplexId}")
	public ResponseEntity<MultiplexDetailDto> updateMultiplexDetail(@PathVariable("multiplexId")String multiplexId,@RequestBody UpdateDetailDto updateDto) {
		MultiplexDetailDto multiplexDetailDto =this.multiplexService.updateMultiplexDetail(multiplexId,updateDto);
		ResponseEntity<MultiplexDetailDto> response = 
				new ResponseEntity<MultiplexDetailDto>(multiplexDetailDto,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addScreen/{multiplexId}")
	public ResponseEntity<ScreenDetailsDto> addScreen(@RequestBody String screenName,@PathVariable("multiplexId") String multiplexId) {
		ScreenDetailsDto screenDetailsDto = this.screenService.addScreen(screenName,multiplexId);
		
		ResponseEntity<ScreenDetailsDto> response = null;		
		if (screenDetailsDto != null) {
			response = new ResponseEntity<ScreenDetailsDto>(screenDetailsDto,HttpStatus.OK);
			} else {
			response = new ResponseEntity<ScreenDetailsDto>(screenDetailsDto,HttpStatus.OK); 
		
			}
		return response;
		//}
	}
	@GetMapping("/getScreens/{multiplexId}")
	public ResponseEntity<List<ScreenDetail>> getAllScreens(@PathVariable("multiplexId") String multiplexId) {
		List<ScreenDetail> getScreens=this.screenService.getAllScreens(multiplexId);
		ResponseEntity<List<ScreenDetail>> response = 
				new ResponseEntity<List<ScreenDetail>>(getScreens,HttpStatus.OK);
		return response;
	}
	@GetMapping("/getScreensToAllot/{multiplexId}")
	public ResponseEntity<List<ScreenDetail>> getAvailableScreens(@PathVariable("multiplexId") String multiplexId) {
		List<ScreenDetail> getScreens=this.screenService.getAvailableScreens(multiplexId);
		ResponseEntity<List<ScreenDetail>> response = 
				new ResponseEntity<List<ScreenDetail>>(getScreens,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addAllotment")
	public ResponseEntity<AllotmentDetailsDto> addAllotment(@RequestBody AddAllotmentDto addAllotmentDto){
		AllotmentDetailsDto allotmentDetailsDto = this.allotedMoviesService.addAllotment(addAllotmentDto);
		ResponseEntity<AllotmentDetailsDto> response = 
				new ResponseEntity<AllotmentDetailsDto>(allotmentDetailsDto,HttpStatus.OK);
		return response;
	}
	@GetMapping("/getAllotmentDetails/{movieId}")
	public ResponseEntity<List<MultiplexDetail>> getMultiplexMovieDetails(@PathVariable("movieId") String movieId){
		List<MultiplexDetail> multiplexes = this.allotedMoviesService.getMultiplexMovieDetails(movieId);
		ResponseEntity<List<MultiplexDetail>> response = 
				new ResponseEntity<List<MultiplexDetail>>(multiplexes,HttpStatus.OK);
		return response;
	}
	
	
}
