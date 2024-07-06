package com.raisingSuperstars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.UserMaster;

public interface UserMasterDaoWrapper extends JpaRepository<UserMaster, Long> {
	
	// check user exists in system or not
	boolean existsByUserNameAndPassword(String userName, String password);
}


