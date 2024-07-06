package com.raisingSuperstars.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.GroupMaster;
import com.raisingSuperstars.model.PostMaster;
import com.raisingSuperstars.model.UserGroupMapping;
import com.raisingSuperstars.model.UserMaster;
import com.raisingSuperstars.repository.GroupMasterDaoWrapper;
import com.raisingSuperstars.repository.PostMasterDaoWrapper;
import com.raisingSuperstars.repository.UserGroupMappingDaoWrapper;
import com.raisingSuperstars.repository.UserMasterDaoWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class GroupMasterService {

	@Autowired
	private GroupMasterDaoWrapper groupMasterDaoWrapper;
	
	@Autowired
	private UserMasterDaoWrapper userMasterDaoWrapper;
	
    @Autowired
    private UserGroupMappingDaoWrapper userGroupMappingDaoWrapper;
    
    @Autowired
    private PostMasterDaoWrapper postMasterDaoWrapper;

	// registerUserIntoGroups
	public UserGroupMapping registerUserIntoGroups(Long userId, Long groupId) {
		
		UserMaster userMaster = userMasterDaoWrapper.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));
		
		GroupMaster groupMaster = groupMasterDaoWrapper.findById(groupId)
				.orElseThrow(() -> new IllegalArgumentException("Group with id " + groupId + " not found"));
		
		Boolean isExists = userGroupMappingDaoWrapper.existsByUserIdAndGroupId(userId, groupId);
		if (isExists) {
	        throw new DataIntegrityViolationException("UserGroupMapping already exists for userId=" + userId + " and groupId=" + groupId);
	    }
		UserGroupMapping ugMapping = new UserGroupMapping();
		ugMapping.setGroupId(groupId);
		ugMapping.setUserId(userId);
		return userGroupMappingDaoWrapper.save(ugMapping);
	}

	//retrieve post from groups they have joined
	public List<PostMaster> retrieveposts(Long userId) {
		
		List<UserGroupMapping> userMasterList = userGroupMappingDaoWrapper.findByUserId(userId);
		if (userMasterList.isEmpty()) {
            throw new RuntimeException("You are not registered in any group.");
        }
		List<Long> groupIdList = new ArrayList<>();
		for(UserGroupMapping model : userMasterList) {
			groupIdList.add(model.getGroupId());
		}
		
		List<PostMaster> posts = postMasterDaoWrapper.findByGroupIdInAndIsDeletedFalse(groupIdList);
		
		
		return posts;
	}



}




