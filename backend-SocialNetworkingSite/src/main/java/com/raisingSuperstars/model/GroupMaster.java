package com.raisingSuperstars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_master")
public class GroupMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;

    @Column(name = "group_name")
    private String groupName;
    
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}

