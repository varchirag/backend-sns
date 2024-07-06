package com.raisingSuperstars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raisingSuperstars.exception.ResourceNotFoundException;
import com.raisingSuperstars.model.PostMaster;
import com.raisingSuperstars.model.UserGroupMapping;
import com.raisingSuperstars.repository.PostMasterDaoWrapper;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/post")
public class PostMasterController {

    @Autowired
    private PostMasterDaoWrapper postMasterRepository;
    
    @GetMapping
    public List<PostMaster> getAllPosts(){
        return postMasterRepository.findAll();
    }

    //create post into system
    @PostMapping(value = "/createpost")
    public PostMaster createPost(@RequestBody PostMaster post) {
        return postMasterRepository.save(post);
    }
    
    //like on a post
    @PostMapping(value = "/likeOnAPost")
    public PostMaster likeOnAPost(@RequestParam("postId") Long postId) {
    	
        PostMaster postDetails = postMasterRepository.findById(postId).orElse(null);
        if (postDetails == null) {
	        throw new DataIntegrityViolationException("Post does not exists");
	    }
        postMasterRepository.incrementLikesById(postId);
        return postDetails;
        
    }
    
    
    
    
    
    
}
