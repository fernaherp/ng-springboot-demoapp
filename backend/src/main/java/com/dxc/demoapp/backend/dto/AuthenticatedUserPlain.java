package com.dxc.demoapp.backend.dto;

import lombok.Data;

@Data()
public class AuthenticatedUserPlain {
	
	private String email;
	private int expTimeInSeconds;
	private String apiKey;

}
