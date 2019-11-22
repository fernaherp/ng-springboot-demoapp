package com.dxc.demoapp.backend.dto;

import lombok.Data;

@Data()
public class AuthenticatedUserPlain {
	
	private String email;
	private long expTime;
	private String token;
	
	public AuthenticatedUserPlain() {}
	
	public AuthenticatedUserPlain( String email, long expTime, String token ) {
		this.email = email;
		this.expTime = expTime;
		this.token = token;
	}

}
