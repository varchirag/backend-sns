package com.raisingSuperstars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.CommentMaster;
import com.raisingSuperstars.model.GroupMaster;
import com.raisingSuperstars.model.PostMaster;
import com.raisingSuperstars.model.UserGroupMapping;

import jakarta.transaction.Transactional;

public interface CommentMasterDaoWrapper extends JpaRepository<CommentMaster, Long> {
	
	
}


