package com.stroygen.urdis2.story.service;

import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.repository.StoryRepository;
import com.stroygen.urdis2.storySource.entity.StorySource;
import com.stroygen.urdis2.storySource.repository.StorySourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoryService {
    private final StoryRepository storyRepository;
    private final StorySourceRepository storySourceRepository;

    public Long saveSourceIdOnStory(Long sourceId) {
        Optional<StorySource> optionalStorySource = storySourceRepository.getByStorySourceId(sourceId);

        if (optionalStorySource.isEmpty()) {
            throw new RuntimeException("존재하지 않는 storySource입니다.");
        }

        StorySource storySource = optionalStorySource.get();

        Story story = storyRepository.save(Story.builder().storySource(storySource).build());

        return story.getStoryId();
    }

}
