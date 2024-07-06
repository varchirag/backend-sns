package com.raisingSuperstars.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.UserMaster;
import com.raisingSuperstars.repository.UserMasterDaoWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserMasterService {

	@Autowired
	private UserMasterDaoWrapper userMasterDaoWrapper;

	// loginUser
	public boolean isUserValid(String userName, String password) {
		
		Boolean loginFlag = userMasterDaoWrapper.existsByUserNameAndPassword(userName, password);
		
		System.out.println(loginFlag);
		return loginFlag;
	}



}




