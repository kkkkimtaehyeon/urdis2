package com.stroygen.urdis2.baseStory.service;

import com.stroygen.urdis2.baseStory.dto.BaseStorySaveRequestDto;
import com.stroygen.urdis2.baseStory.entity.BaseStory;
import com.stroygen.urdis2.baseStory.exception.BaseStoryNotFoundException;
import com.stroygen.urdis2.baseStory.repository.BaseStoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BaseStoryService {

    private final BaseStoryRepository baseStoryRepository;

    public Long save(BaseStorySaveRequestDto baseStorySaveRequestDto) {

        BaseStory baseStory = baseStoryRepository.save(baseStorySaveRequestDto.toEntity());

        return baseStory.getBaseStoryId();
    }

    public BaseStory get(Long baseStoryId) {
        Optional<BaseStory> optionalBaseStory = baseStoryRepository.findByBaseStoryId(baseStoryId);

        return optionalBaseStory.orElseThrow(() -> new BaseStoryNotFoundException(baseStoryId));
    }

}
