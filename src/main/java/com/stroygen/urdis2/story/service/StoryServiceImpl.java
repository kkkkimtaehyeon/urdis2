package com.stroygen.urdis2.story.service;

import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.repository.StoryRepository;
import com.stroygen.urdis2.baseStory.entity.BaseStory;
import com.stroygen.urdis2.baseStory.repository.BaseStoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoryServiceImpl {
    private final StoryRepository storyRepository;
    private final BaseStoryRepository baseStoryRepository;

    public Long saveSourceIdOnStory(Long sourceId) {
        Optional<BaseStory> optionalStorySource = baseStoryRepository.getByBaseStoryId(sourceId);

        if (optionalStorySource.isEmpty()) {
            throw new RuntimeException("존재하지 않는 storySource입니다.");
        }

        BaseStory baseStory = optionalStorySource.get();

        Story story = storyRepository.save(Story.builder().storySource(baseStory).build());

        return story.getStoryId();
    }

}
