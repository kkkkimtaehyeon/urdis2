package com.stroygen.urdis2.story.service;

import com.stroygen.urdis2.story.dto.StoryInitializerDto;
import com.stroygen.urdis2.story.dto.StoryUpdateDto;
import com.stroygen.urdis2.story.entity.Story;

import java.util.List;

public interface StoryService {
    Long initialize(StoryInitializerDto storyInitializerDto);

    Story getStory(Long storyId);
    List<Story> getStories(Long userId);
    void removeStory(Long storyId);
    Story modifyStory(StoryUpdateDto storyUpdateDto);
}
