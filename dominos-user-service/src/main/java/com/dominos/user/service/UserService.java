package com.dominos.user.service;

import com.dominos.user.dto.UserLoginRequestDTO;
import com.dominos.user.dto.UserRegisterRequestDTO;
import com.dominos.user.dto.UserResponseDTO;

public interface UserService {

	String registerUser(UserRegisterRequestDTO dto);

	UserResponseDTO loginUser(UserLoginRequestDTO dto);
}
