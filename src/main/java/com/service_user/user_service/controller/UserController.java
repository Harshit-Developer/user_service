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
	public ResponseEntity<String> userSignUp(@RequestBody User user){
		logger.info("Inside SignUp Controller of UserController" + user.toString());
		ResponseEntity<String> signUpresponse  = userService.userSignUp(user);
		return  signUpresponse;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody Login login){
		UserDto savedUser = userService.login(login);
		if(savedUser==null) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	 
	

}
