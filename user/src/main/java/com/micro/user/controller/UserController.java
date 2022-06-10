package com.micro.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.user.dto.LoginUserDto;
import com.micro.user.dto.RegisterUserDto;
import com.micro.user.dto.UserDetailsDto;
import com.micro.user.dto.UserExceptionDto;
import com.micro.user.exception.BoundaryException;
import com.micro.user.service.UserService;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin("*")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDetailsDto> register(@RequestBody RegisterUserDto registerUserDto) {
		UserDetailsDto userDetailDto = this.userService.register(registerUserDto);
		ResponseEntity<UserDetailsDto> response = 
				new ResponseEntity<UserDetailsDto>(userDetailDto,HttpStatus.OK);
		return response;
	}
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password){
		String message = "User logged in !";
		
		
		ResponseEntity<String> response = 
				new ResponseEntity<String>(message,HttpStatus.OK);
		return response;
	}
	
	/*@PostMapping("/login")
	public ResponseEntity<UserDetailsDto> login(@Valid @RequestBody LoginUserDto loginUserDto
												, BindingResult result){
		
		if(result.hasErrors()) {
			throw new BoundaryException("Password not in correct format!!!");
		}
		UserDetailsDto userDetailDto =  this.userService.login(loginUserDto);
		
		
		ResponseEntity<UserDetailsDto> response = 
				new ResponseEntity<UserDetailsDto>(userDetailDto,HttpStatus.OK);
		return response;
	}*/
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDetailsDto> getUserDetail(@PathVariable("userId") String userId){
		UserDetailsDto userDetailDto =  this.userService.getUserDetail(userId);
		// manage user not found exception
		ResponseEntity<UserDetailsDto> response = 
				new ResponseEntity<UserDetailsDto>(userDetailDto,HttpStatus.OK);
		return response;
	}
	
	
	@ExceptionHandler(BoundaryException.class)
	public ResponseEntity<UserExceptionDto> boundaryExceptionHanler(BoundaryException ex) {
		UserExceptionDto userExceptionDto = 
				new UserExceptionDto(ex.getMessage(), 
									HttpStatus.BAD_REQUEST.value(), 
									System.currentTimeMillis());
		ResponseEntity<UserExceptionDto> response = 
				new ResponseEntity<UserExceptionDto>(userExceptionDto, HttpStatus.BAD_REQUEST);
		return response;
	}


}
