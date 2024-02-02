package com.service_user.user_service.service;

import com.service_user.user_service.dto.UserDto;
import com.service_user.user_service.entity.Login;
import com.service_user.user_service.entity.User;

public interface UserService {

	public UserDto userSignUp(User user);
	public UserDto login(Login login);
	
}
