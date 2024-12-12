package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.baseStory.BaseStorySaveRequestDto;
import com.stroygen.urdis2.dto.story.StoryInitializerDto;
import com.stroygen.urdis2.dto.story.StorySaveDto;
import com.stroygen.urdis2.dto.story.StoryUpdateDto;
import com.stroygen.urdis2.entity.Story;

import java.util.List;

public interface StoryService {
    Long saveBaseStory(BaseStorySaveRequestDto saveRequest);
}
