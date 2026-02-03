package com.zomato.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zomato.user.dto.UserLoginRequestDTO;
import com.zomato.user.dto.UserRegisterRequestDTO;
import com.zomato.user.dto.UserResponseDTO;
import com.zomato.user.dto.UserUpdateRequestDTO;
import com.zomato.user.entity.Role;
import com.zomato.user.entity.User;
import com.zomato.user.exception.UserNotFoundException;
import com.zomato.user.repository.UserRepository;
import com.zomato.user.security.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String registerUser(UserRegisterRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setMobile(dto.getMobile());
		user.setPassword(encoder.encode(dto.getPassword()));

		user.setRole(Role.valueOf(dto.getRole())); // CUSTOMER / ADMIN / DELIVERY_BOY

		repository.save(user);
		return "User registered successfully";
	}

	@Override
	public UserResponseDTO loginUser(UserLoginRequestDTO dto) {

		User user = repository.findByEmail(dto.getEmail())
				.orElseThrow(() -> new UserNotFoundException("Invalid email or password"));

		if (!encoder.matches(dto.getPassword(), user.getPassword())) {
			throw new UserNotFoundException("Invalid email or password");
		}

		String token = jwtUtil.generateToken(user.getEmail());

		UserResponseDTO response = new UserResponseDTO();
		response.setUserId(user.getUserId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setMobile(user.getMobile());
		response.setRole(user.getRole().name());
		response.setToken(token);

		return response;
	}

	@Override
	public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {

		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

		user.setName(dto.getName());
		user.setMobile(dto.getMobile());
		repository.save(user);

		UserResponseDTO res = new UserResponseDTO();
		res.setUserId(user.getUserId());
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setMobile(user.getMobile());
		res.setRole(user.getRole().name());

		return res;
	}

	@Override
	public String deleteUser(Long id) {
		repository.deleteById(id);
		return "User deleted";
	}
}
