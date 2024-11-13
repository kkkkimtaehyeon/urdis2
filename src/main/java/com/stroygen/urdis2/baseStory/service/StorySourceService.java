package com.stroygen.urdis2.baseStory.service;

import com.stroygen.urdis2.baseStory.dto.BaseStorySaveRequestDto;
import com.stroygen.urdis2.baseStory.entity.BaseStory;
import com.stroygen.urdis2.baseStory.repository.BaseStoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StorySourceService {

    private final BaseStoryRepository baseStoryRepository;

    public Long save(BaseStorySaveRequestDto baseStorySaveRequestDto) {

        BaseStory baseStory = baseStoryRepository.save(baseStorySaveRequestDto.toEntity());

        return baseStory.getBaseStoryId();
    }

}
