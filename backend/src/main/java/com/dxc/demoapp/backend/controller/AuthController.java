package com.dxc.demoapp.backend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.demoapp.backend.dto.AuthenticatedUserPlain;
import com.dxc.demoapp.backend.dto.UserPlain;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticatedUserPlain> login( @RequestBody UserPlain userPlain, HttpSession session ) {
		AuthenticatedUserPlain authenticatedUserPlain = null;
		
		if ( "fernando-alonsoh@dxc.com".equals( userPlain.getEmail()) && "123456".equals( userPlain.getPassword() ) ) {
			authenticatedUserPlain = new AuthenticatedUserPlain();
			authenticatedUserPlain.setToken("18377972rgyegyjfejfvaekfefu7y73731qjkfjkfkqwefjkekjfwe--ewfukwefh");
			authenticatedUserPlain.setExpTime(3600);
			authenticatedUserPlain.setEmail(userPlain.getEmail());
			
			return new ResponseEntity<AuthenticatedUserPlain>(authenticatedUserPlain, HttpStatus.OK);
		} else {
			return new ResponseEntity<AuthenticatedUserPlain>(authenticatedUserPlain, HttpStatus.UNAUTHORIZED);
		}
	}

}
