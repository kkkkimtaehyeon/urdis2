package com.stroygen.urdis2.storySource.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorySourceResponseDto {
    private Long storyId;

    public StorySourceResponseDto(Long id) {
        this.storyId = id;
    }
}

