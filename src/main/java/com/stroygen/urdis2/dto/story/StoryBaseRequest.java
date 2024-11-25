package com.stroygen.urdis2.dto.story;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public record StoryBaseRequest(
        @NotNull @Length(min = 1, max = 1000) String baseStory) {
}
