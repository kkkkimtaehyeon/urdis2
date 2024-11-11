package com.stroygen.urdis2.story.entity;

import com.stroygen.urdis2.storySource.entity.StorySource;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyId;

    @Column(length = 50)
    private String storyTitle;
    private LocalDateTime createdAt;
    private Integer likeCount = 0;
    private Integer viewCount = 0;
    private Boolean isPublic = false;
    @ManyToOne
    @JoinColumn(name = "story_source_id")
    private StorySource storySource;

    @Builder
    public Story(Long storyId, String storyTitle, LocalDateTime createdAt, Integer likeCount, Integer viewCount, Boolean isPublic, StorySource storySource) {
        this.storyId = storyId;
        this.storyTitle = storyTitle;
        this.createdAt = createdAt;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.isPublic = isPublic;
        this.storySource = storySource;
    }
}

