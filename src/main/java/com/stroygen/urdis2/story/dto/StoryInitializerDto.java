package com.stroygen.urdis2.story.dto;

import com.stroygen.urdis2.baseStory.entity.BaseStory;
import com.stroygen.urdis2.story.entity.Story;
import lombok.Data;

@Data
public class StoryInitializerDto {
    private BaseStory baseStory;

    public StoryInitializerDto(BaseStory baseStory) {
        this.baseStory = baseStory;
    }

    public Story toEntity() {
        return Story.builder()
                .baseStory(this.baseStory)
                .build();
    }
}
