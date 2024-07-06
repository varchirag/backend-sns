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
@Table(name = "comment_master")
public class CommentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_on")
    private Timestamp createdOn;
    
    @Column(name = "post_id")
    private Long postId;

}

