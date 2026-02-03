package com.zomato.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.user.dto.UserLoginRequestDTO;
import com.zomato.user.dto.UserRegisterRequestDTO;
import com.zomato.user.dto.UserResponseDTO;
import com.zomato.user.dto.UserUpdateRequestDTO;
import com.zomato.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody UserRegisterRequestDTO dto) {
		return ResponseEntity.ok(service.registerUser(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody UserLoginRequestDTO dto) {
		return ResponseEntity.ok(service.loginUser(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserUpdateRequestDTO dto) {
		return ResponseEntity.ok(service.updateUser(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok(service.deleteUser(id));
	}
}
