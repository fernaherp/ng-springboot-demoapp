package com.dxc.demoapp.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.demoapp.backend.dto.AuthenticatedUserPlain;
import com.dxc.demoapp.backend.dto.UserPlain;

@RestController
@CrossOrigin
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticatedUserPlain	> login( @RequestBody UserPlain userPlain ) {
		AuthenticatedUserPlain authenticatedUserPlain = null;
		
		if ( "fernaherp@gmail.com".equals( userPlain.getEmail()) ) {
			authenticatedUserPlain = new AuthenticatedUserPlain();
			authenticatedUserPlain.setApiKey("18377972rgyegyjfejfvaekfefu7y73731qjkfjkfkqwefjkekjfwe--ewfukwefh");
			authenticatedUserPlain.setExpTimeInSeconds(3600);
			authenticatedUserPlain.setEmail(userPlain.getEmail());
			
			return new ResponseEntity<AuthenticatedUserPlain>(authenticatedUserPlain, HttpStatus.OK);
		} else {
			return new ResponseEntity<AuthenticatedUserPlain>(authenticatedUserPlain, HttpStatus.UNAUTHORIZED);
		}
	}

}
