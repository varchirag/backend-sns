package com.raisingSuperstars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.GroupMaster;

public interface GroupMasterDaoWrapper extends JpaRepository<GroupMaster, Long> {
    
	
	
}


