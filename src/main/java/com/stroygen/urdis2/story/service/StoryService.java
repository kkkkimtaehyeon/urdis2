package com.stroygen.urdis2.story.service;

import com.stroygen.urdis2.story.entity.Story;

import java.util.List;

public interface StoryService {
    Story save(StorySaveDto storySaveDto);
    Story getStory(Long storyId);
    List<Story> getStories(Long userId);
    void removeStory(Long storyId);
    Story modifyStory(StoryUpdateDto storyUpdateDto);
}
