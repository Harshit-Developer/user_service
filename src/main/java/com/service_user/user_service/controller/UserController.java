package com.service_user.user_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service_user.user_service.dto.UserDto;
import com.service_user.user_service.entity.Login;
import com.service_user.user_service.entity.User;
import com.service_user.user_service.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// This function recieves RegisterAuthRequest type from the auth service
	@PostMapping("/signup")
	public UserDto userSignUp(@RequestBody User user){
		logger.info("Request recieved by SignUp in UserController " + user.toString());
		UserDto signUpresponse  = userService.userSignUp(user);
		
		logger.info("Request executed by SignUp in UserController with response" + signUpresponse.toString());
		return  signUpresponse;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody Login login){
		logger.info("Request recieved by login in UserController " + login.toString());
		User loggedUser = userService.login(login);
		
		logger.info("Request executed by login in UserController with response" + loggedUser.toString());
		return loggedUser;
	}
	 
	

}
