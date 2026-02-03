package com.dominos.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominos.user.dto.UserLoginRequestDTO;
import com.dominos.user.dto.UserRegisterRequestDTO;
import com.dominos.user.dto.UserResponseDTO;
import com.dominos.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	// Register
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody UserRegisterRequestDTO dto) {
		return ResponseEntity.ok(service.registerUser(dto));
	}

	// Login
	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody UserLoginRequestDTO dto) {
		return ResponseEntity.ok(service.loginUser(dto));
	}
}
