package com.service_user.user_service.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.service_user.user_service.controller.UserController;
import com.service_user.user_service.dto.UserDto;
import com.service_user.user_service.entity.Login;
import com.service_user.user_service.entity.User;
//import com.service_user.user_service.mapper.UserDtoMapper;
import com.service_user.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public  ResponseEntity<String> userSignUp(User user) {
		try {
			logger.info("Inside try of  userSignUp Service of UserController");
			if (userRepository.existsByEmail(user.getEmail())) {
	            throw new IllegalArgumentException("Email is already registered");
	        }

	        userRepository.save(user);

			User savedUser = userRepository.save(user);
			return  ResponseEntity.ok("User Created Successfully");		}
		catch(IllegalArgumentException e) {
			logger.info("Inside catch of  userSignUp Service of UserController"+e.getMessage());
			return  ResponseEntity.status(400).body("User Already exists");
		}
	}
	// Comment Added.

	@Override
	public UserDto login(Login login) {
        
//	    Optional<User> result = userRepository.findByEmail(login.getEmail());
//	   
//	    if(!result.get().getEmail().equals(login.getEmail())) {
//	    	return null;
//	    }
//	    UserDto retrievedUserDto = null;
//	    if(result.isPresent()) {
//	        User retrievedUser = result.get();
//	        //retrievedUserDto = UserDtoMapper.convertToDto(retrievedUser);
//	    }
//	    else {
//	        // we didn't find the user
//	        throw new RuntimeException("Did not find userId: " + retrievedUserDto);
//	    }
    return null;
	}

}
