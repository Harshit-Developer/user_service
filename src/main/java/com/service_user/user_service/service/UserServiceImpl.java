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
import com.service_user.user_service.mapper.UserDtoMapper;
//import com.service_user.user_service.mapper.UserDtoMapper;
import com.service_user.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public  UserDto userSignUp(User user) {
		try {
			logger.info("Checking if the email exist in DB");
			if (userRepository.existsByEmail(user.getEmail())) {
	            throw new IllegalArgumentException("Email is already registered");
	        }
			
			logger.info("Trying to register the User");
	        userRepository.save(user);

	        logger.info("User Registered Successfully");
			User savedUser = userRepository.save(user);
			UserDto userDto = UserDtoMapper.convertToDto(savedUser);
			
			logger.info("UserSignUp Executed Successfully with response "+userDto.toString());
			return userDto;
			
			}
		catch (IllegalArgumentException e) {
			logger.info("Error occured while registering user. "+e.getMessage());
			return  null;
		} catch (Exception e) {
			logger.info("Error occured while registering user. "+e.getMessage());
			return  null;
		}
	}
	// Comment Added.

	@Override
	public User login(Login login) {
        
		try {
			Optional<User> result = userRepository.findByEmail(login.getEmail());
			if(!result.get().getEmail().equals(login.getEmail())) {
				throw new IllegalArgumentException("Invalid username or password");
		    }
			
			User loggedUser = result.get();
			logger.info("Userlogin Executed Successfully with response "+loggedUser.toString());
			return loggedUser;
		}
		catch (IllegalArgumentException e) {
			logger.info("Error occured while logging user "+e.getMessage());
			return  null;
		} catch (Exception e) {
			logger.info("Error occured while logging user. "+e.getMessage());
			return  null;
		}
	}

}
