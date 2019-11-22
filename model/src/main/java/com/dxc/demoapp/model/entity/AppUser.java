package com.dxc.demoapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "user")
@Data
public class AppUser {
	
	@Id
	@Column(name = "iduser")
	private Long idUser;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

}
