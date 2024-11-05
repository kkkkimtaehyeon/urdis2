package com.stroygen.urdis2.story.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storyId;

    private String storyTitle;
    private String storySource;
    private LocalDateTime createdAt;
    private long likeCount;
    private long viewCount;
    private boolean isPublic;

}
