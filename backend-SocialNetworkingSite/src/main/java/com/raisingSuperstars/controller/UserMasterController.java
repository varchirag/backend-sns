package com.raisingSuperstars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raisingSuperstars.exception.ResourceNotFoundException;
import com.raisingSuperstars.model.UserMaster;
import com.raisingSuperstars.repository.UserMasterDaoWrapper;
import com.raisingSuperstars.service.UserMasterService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserMasterController {

    @Autowired
    private UserMasterDaoWrapper userMasterRepository;
    
    @Autowired
    private UserMasterService userMasterService;

    @GetMapping
    public List<UserMaster> getAllUsers(){
        return userMasterRepository.findAll();
    }

    //create user into system
    @PostMapping(value = "/createUser")
    public UserMaster createUser(@RequestBody UserMaster user) {
        return userMasterRepository.save(user);
    }
    
    //login user into system
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public boolean Login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		boolean loginFlag = userMasterService.isUserValid(userName,password);
		return loginFlag;
	}
    
    
}
