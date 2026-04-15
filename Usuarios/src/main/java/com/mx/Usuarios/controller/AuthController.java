package com.mx.Usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Usuarios.config.JwtUtil;

@RestController
public class AuthController {
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if("admin".equals(username) && "1234".equals(password)) {
			return jwtUtil.generarToken(username);
		}
		return "Credenciales invalidas";
	}
}
