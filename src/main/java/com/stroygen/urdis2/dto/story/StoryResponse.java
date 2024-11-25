package com.stroygen.urdis2.dto.story;

import com.stroygen.urdis2.entity.Story;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StoryResponse {
    private String title;
    private LocalDateTime createdAt;
    private int likeCount;
    private int viewCount;
    private boolean isPublic;
    //private MemberResponse member

    public StoryResponse(Story story) {
        this.title = story.getStoryTitle();
        this.createdAt = story.getCreatedAt();
        this.likeCount = story.getLikeCount();
        this.viewCount = story.getViewCount();
        this.isPublic = story.getIsPublic();
    }
}
