package com.raisingSuperstars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raisingSuperstars.exception.ResourceNotFoundException;
import com.raisingSuperstars.model.CommentMaster;
import com.raisingSuperstars.model.UserGroupMapping;
import com.raisingSuperstars.repository.CommentMasterDaoWrapper;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/comment")
public class CommentMasterController {

    @Autowired
    private CommentMasterDaoWrapper commentMasterRepository;
    

    //add comment into system
    @PostMapping(value = "/createcomment")
    public CommentMaster createcomment(@RequestBody CommentMaster comment) {
        return commentMasterRepository.save(comment);
    }
    
    
    
    
    
    
    
}
