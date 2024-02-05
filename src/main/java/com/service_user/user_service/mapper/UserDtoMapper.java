package com.service_user.user_service.mapper;

import com.service_user.user_service.dto.UserDto;
import com.service_user.user_service.entity.User;

public class UserDtoMapper {

	public static UserDto convertToDto(User user) {
		UserDto userDto = new UserDto(
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getRole()
				);
		
	return userDto;	
	}
	
	public static User convertToUser(UserDto userDto) {
		return null;
		
	}
}
