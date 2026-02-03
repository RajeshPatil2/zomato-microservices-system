package com.dominos.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.user.dto.UserLoginRequestDTO;
import com.dominos.user.dto.UserRegisterRequestDTO;
import com.dominos.user.dto.UserResponseDTO;
import com.dominos.user.entity.User;
import com.dominos.user.exception.UserNotFoundException;
import com.dominos.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public String registerUser(UserRegisterRequestDTO dto) {

		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setMobile(dto.getMobile());

		repository.save(user);
		return "User registered successfully";
	}

	@Override
	public UserResponseDTO loginUser(UserLoginRequestDTO dto) {

		User user = repository.findByEmail(dto.getEmail())
				.orElseThrow(() -> new UserNotFoundException("Invalid email or password"));

		if (!user.getPassword().equals(dto.getPassword())) {
			throw new UserNotFoundException("Invalid email or password");
		}

		UserResponseDTO response = new UserResponseDTO();
		response.setUserId(user.getUserId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setMobile(user.getMobile());

		return response;
	}

}
