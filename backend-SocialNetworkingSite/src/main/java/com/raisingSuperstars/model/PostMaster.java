package com.raisingSuperstars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_master")
public class PostMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(name = "post_details")
    private String postDetails;

    @Column(name = "post_heading")
    private String postHeading;

    @Column(name = "post_auther")
    private String postAuther;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_on")
    private Timestamp createdOn;
    
    @Column(name = "updated_by")
    private String updatedBy;
    
    @Column(name = "updated_on")
    private Timestamp updatedOn;
    
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    @Column(name = "group_id")
    private Long groupId;
    
    @Column(name = "no_of_likes")
    private Integer noOfLikes;
}

