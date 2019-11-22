package com.dxc.demoapp.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dxc.demoapp.model.entity.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
	
	public List<AppUser> findByEmail(String email);

}
