package com.service_user.user_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service_user.user_service.dto.UserDto;
import com.service_user.user_service.entity.Login;
import com.service_user.user_service.entity.User;
import com.service_user.user_service.mapper.UserDtoMapper;
import com.service_user.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	@Override
	public UserDto userSignUp(User user) {
		User savedUser = userRepository.save(user);
		UserDto savedUserDto = UserDtoMapper.convertToDto(savedUser);
		return savedUserDto;
	}

	@Override
	public UserDto login(Login login) {
        
	    Optional<User> result = userRepository.findByEmail(login.getEmail());
	   
	    if(!result.get().getEmail().equals(login.getEmail())) {
	    	return null;
	    }
	    UserDto retrievedUserDto = null;
	    if(result.isPresent()) {
	        User retrievedUser = result.get();
	        retrievedUserDto = UserDtoMapper.convertToDto(retrievedUser);
	    }
	    else {
	        // we didn't find the user
	        throw new RuntimeException("Did not find userId: " + retrievedUserDto);
	    }
	    return retrievedUserDto;
	}

}
