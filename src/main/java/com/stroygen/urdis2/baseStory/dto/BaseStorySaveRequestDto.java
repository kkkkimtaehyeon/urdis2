package com.stroygen.urdis2.baseStory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stroygen.urdis2.baseStory.entity.BaseStory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseStorySaveRequestDto {
    @NotBlank
    @Size(min = 1, max = 1000)
    @JsonProperty("baseStory")
    private String baseStory;

    public BaseStory toEntity() {
        return new BaseStory(this.baseStory);
    }
}
