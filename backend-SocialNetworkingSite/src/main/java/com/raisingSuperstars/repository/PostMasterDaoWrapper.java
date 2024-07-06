package com.raisingSuperstars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raisingSuperstars.model.GroupMaster;
import com.raisingSuperstars.model.PostMaster;
import com.raisingSuperstars.model.UserGroupMapping;

import jakarta.transaction.Transactional;

public interface PostMasterDaoWrapper extends JpaRepository<PostMaster, Long> {
    //Get all the posts from groups which user have joined
	List<PostMaster> findByGroupIdInAndIsDeletedFalse(List<Long> groupIds);

	//update no of likes by 1
	@Transactional
    @Modifying
    @Query("UPDATE PostMaster p SET p.noOfLikes = p.noOfLikes + 1 WHERE p.postId = :postId")
	void incrementLikesById(Long postId);
	
	
}


