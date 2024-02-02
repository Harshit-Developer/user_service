package com.service_user.user_service.controller;

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
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserDto> userSignUp(@RequestBody User user){
		UserDto savedUser = userService.userSignUp(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
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
