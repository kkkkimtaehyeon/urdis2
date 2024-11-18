package com.stroygen.urdis2.dto.baseStory;

import lombok.Data;

@Data
public class BaseStorySaveResponseDto {
    private Long storyId;
    private String baseStory;

    public BaseStorySaveResponseDto(Long storyId, String baseStory) {
        this.storyId = storyId;
        this.baseStory = baseStory;
    }
}
