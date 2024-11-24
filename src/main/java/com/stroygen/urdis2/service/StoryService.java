package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.story.StoryInitializerDto;
import com.stroygen.urdis2.dto.story.StorySaveDto;
import com.stroygen.urdis2.dto.story.StoryUpdateDto;
import com.stroygen.urdis2.entity.Story;

import java.util.List;

public interface StoryService {
    Long initialize(StoryInitializerDto storyInitializerDto);

    Story getStory(Long storyId);
    List<Story> getStories(Long memberId);
    void removeStory(Long storyId);
    Story modifyStory(StoryUpdateDto storyUpdateDto);
    boolean isStoryExists(Long storyId);
    Story finalizeStory(Long storyId, StorySaveDto storySaveDto);
}
