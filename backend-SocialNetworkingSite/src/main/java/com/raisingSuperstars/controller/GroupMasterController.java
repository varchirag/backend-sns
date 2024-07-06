package com.raisingSuperstars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raisingSuperstars.exception.ResourceNotFoundException;
import com.raisingSuperstars.model.GroupMaster;
import com.raisingSuperstars.model.PostMaster;
import com.raisingSuperstars.model.UserGroupMapping;
import com.raisingSuperstars.repository.GroupMasterDaoWrapper;
import com.raisingSuperstars.repository.UserGroupMappingDaoWrapper;
import com.raisingSuperstars.service.GroupMasterService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/group")
public class GroupMasterController {

    @Autowired
    private GroupMasterDaoWrapper groupMasterRepository;
    
    @Autowired
    private UserGroupMappingDaoWrapper userGroupMappingRepository;
    
    @Autowired
    private GroupMasterService groupMasterService;
    
    
    @GetMapping
    public List<GroupMaster> getAllgroups(){
        return groupMasterRepository.findAll();
    }

    //create group into system
    @PostMapping(value = "/createGroup")
    public GroupMaster createGroup(@RequestBody GroupMaster group) {
        return groupMasterRepository.save(group);
    }
    
    //register users into groups
    @PostMapping(value = "/registerUserIntoGroup")
    public UserGroupMapping registerUserIntoGroup(@RequestParam("userId") Long userId, @RequestParam("groupId") Long groupId) {
    	
        return groupMasterService.registerUserIntoGroups(userId, groupId);
    }
    
    //retrieve the posts from groups which user joined
    @PostMapping(value = "/retrievePosts")
    public List<PostMaster> retrievePosts(@RequestParam("userId") Long userId) {
			return groupMasterService.retrieveposts(userId);
     
    }
    
    
   
    
    
}
