package com.stroygen.urdis2.story.service.impl;

import com.stroygen.urdis2.story.dto.StoryInitializerDto;
import com.stroygen.urdis2.story.dto.StorySaveDto;
import com.stroygen.urdis2.story.dto.StoryUpdateDto;
import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.repository.StoryRepository;
import com.stroygen.urdis2.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    @Override
    public Long initialize(StoryInitializerDto storyInitializerDto) {
        Story story = storyRepository.save(storyInitializerDto.toEntity());
        return story.getStoryId();
    }

    @Override
    public Story getStory(Long storyId) {
        return null;
    }

    @Override
    public List<Story> getStories(Long userId) {
        return List.of();
    }

    @Override
    public void removeStory(Long storyId) {

    }

    @Override
    public Story modifyStory(StoryUpdateDto storyUpdateDto) {
        return null;
    }
}
