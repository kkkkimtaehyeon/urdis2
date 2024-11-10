package com.stroygen.urdis2.story.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storyId;

    @Column(length = 50)
    private String storyTitle;
    @Column(length = 1000, nullable = false)
    private String storySource;
    private LocalDateTime createdAt;
    private Long likeCount;
    private Long viewCount;
    private Boolean isPublic;

}
