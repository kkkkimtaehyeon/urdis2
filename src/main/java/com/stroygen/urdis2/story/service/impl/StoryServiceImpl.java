package com.stroygen.urdis2.story.service.impl;

import com.stroygen.urdis2.exception.StoryNotFoundException;
import com.stroygen.urdis2.story.dto.StoryInitializerDto;
import com.stroygen.urdis2.story.dto.StoryUpdateDto;
import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.repository.StoryRepository;
import com.stroygen.urdis2.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Story> optionalStory = storyRepository.findById(storyId);
        return optionalStory.orElseThrow(() -> new StoryNotFoundException(storyId));
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

    @Override
    public boolean isStoryExists(Long storyId) {
        return storyRepository.existsById(storyId);
    }
}
