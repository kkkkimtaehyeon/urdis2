package com.stroygen.urdis2.dto.story;

import com.stroygen.urdis2.entity.BaseStory;
import com.stroygen.urdis2.entity.Story;
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
