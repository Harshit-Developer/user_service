package com.service_user.user_service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private long id;
	private String username;
	private String email;
	private String role;

}
