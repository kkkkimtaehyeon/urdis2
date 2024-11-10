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
    private LocalDateTime createdAt;
    private Long likeCount;
    private Long viewCount;
    private Boolean isPublic;

}
