package com.micro.user.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.user.dao.UserRepository;
import com.micro.user.document.UserDetail;
import com.micro.user.dto.LoginUserDto;
import com.micro.user.dto.RegisterUserDto;
import com.micro.user.dto.UserDetailsDto;
@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	@Override
	public UserDetailsDto register(RegisterUserDto registerUserDto) {
		UserDetail userDetail = new UserDetail(null, 
				   registerUserDto.getEmailId(), 
				   registerUserDto.getPassword(), 
				   registerUserDto.getFirstName(), 
				   registerUserDto.getLastName(),
				   registerUserDto.getUserGroup());
           userDetail = this.repository.save(userDetail);

           UserDetailsDto userDetailDto = new UserDetailsDto
        		   (userDetail.getId(), 
					userDetail.getEmailId(), 
					userDetail.getFirstName(), 
					userDetail.getLastName(),
					userDetail.getUserGroup());
           return userDetailDto;
	}

	@Override
	public UserDetailsDto login(LoginUserDto loginUserDto) {
		List<UserDetail> userDetails = this.repository.findByEmailIdAndPassword(loginUserDto.getLoginId(), loginUserDto.getPassword());
		if(userDetails.size() > 0) {
			UserDetail userDetail = userDetails.get(0);
			UserDetailsDto userDetailDto = new UserDetailsDto(userDetail.getId(), 
											userDetail.getEmailId(), 
											userDetail.getFirstName(), 
											userDetail.getLastName(),
											userDetail.getUserGroup());
			return userDetailDto;
		}
		
		return null;
	}

	@Override
	public boolean checkAlreadyInUse(String emailId) {
		
		return false;
	}

	@Override
	public UserDetailsDto getUserDetail(String userId) {
		UserDetail userDetail =  this.repository.findById(userId).orElse(null);
		if(userDetail != null) {
			UserDetailsDto userDetailDto = new UserDetailsDto(userDetail.getId(), 
										userDetail.getEmailId(), 
										userDetail.getFirstName(), 
										userDetail.getLastName(),
										userDetail.getUserGroup());
			return userDetailDto;
		}
		return null;
    }

}