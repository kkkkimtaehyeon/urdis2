package com.stroygen.urdis2.story.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storyId;

    @Column(name = "story_title", length = 50)
    private String storyTitle;
    private String storySource;
    private LocalDateTime createdAt;
    private long likeCount;
    private long viewCount;
    private boolean isPublic;

}
