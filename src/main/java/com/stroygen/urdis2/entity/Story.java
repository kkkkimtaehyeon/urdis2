package com.stroygen.urdis2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long storyId;

    @Column(length = 50)
    private String storyTitle;
    private LocalDateTime createdAt;
    private Integer likeCount = 0;
    private Integer viewCount = 0;
    private Boolean isPublic = false;
    private String baseStory;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Story(Long storyId, String storyTitle, LocalDateTime createdAt, Integer likeCount, Integer viewCount, Boolean isPublic, String baseStory, Member member) {
        this.storyId = storyId;
        this.storyTitle = storyTitle;
        this.createdAt = createdAt;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.isPublic = isPublic;
        this.baseStory = baseStory;
        this.member = member;
    }
}

