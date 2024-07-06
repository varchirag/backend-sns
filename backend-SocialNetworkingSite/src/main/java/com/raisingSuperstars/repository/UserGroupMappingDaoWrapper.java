package com.raisingSuperstars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.GroupMaster;
import com.raisingSuperstars.model.UserGroupMapping;

public interface UserGroupMappingDaoWrapper extends JpaRepository<UserGroupMapping, Long> {
    
	//To check that user and group combination exists or not
	boolean existsByUserIdAndGroupId(Long userId, Long groupId);
	
	//Fetch all the records by userId
	List<UserGroupMapping> findByUserId(Long userId);
	
}


