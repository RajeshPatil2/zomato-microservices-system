package com.zomato.user.service;

import com.zomato.user.dto.UserLoginRequestDTO;
import com.zomato.user.dto.UserRegisterRequestDTO;
import com.zomato.user.dto.UserResponseDTO;
import com.zomato.user.dto.UserUpdateRequestDTO;

public interface UserService {

	String registerUser(UserRegisterRequestDTO dto);

	UserResponseDTO loginUser(UserLoginRequestDTO dto);

	UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto);

	String deleteUser(Long id);
}
