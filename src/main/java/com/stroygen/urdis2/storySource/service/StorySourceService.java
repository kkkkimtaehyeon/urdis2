package com.stroygen.urdis2.storySource.service;

import com.stroygen.urdis2.storySource.dto.StorySourceSaveDto;
import com.stroygen.urdis2.storySource.entity.StorySource;
import com.stroygen.urdis2.storySource.repository.StorySourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StorySourceService {

    private final StorySourceRepository storySourceRepository;

    public Long save(StorySourceSaveDto storySourceSaveDto) {

        StorySource createdStorySource = storySourceRepository.save(storySourceSaveDto.toEntity());

        return createdStorySource.getStorySourceId();
    }

}
