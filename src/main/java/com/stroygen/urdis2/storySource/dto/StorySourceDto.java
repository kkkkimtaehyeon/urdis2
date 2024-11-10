package com.stroygen.urdis2.storySource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stroygen.urdis2.storySource.entity.StorySource;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorySourceDto {
    @NotBlank
    @Size(min = 1, max = 1000)
    @JsonProperty("story-source")
    private String storySource;

    public StorySource toEntity() {
        return new StorySource(this.storySource);
    }
}
