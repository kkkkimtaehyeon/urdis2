package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.baseStory.BaseStorySaveRequestDto;
import com.stroygen.urdis2.dto.story.StorySaveDto;
import com.stroygen.urdis2.entity.Member;
import com.stroygen.urdis2.exception.MemberNotFoundException;
import com.stroygen.urdis2.exception.StoryNotFoundException;
import com.stroygen.urdis2.dto.story.StoryInitializerDto;
import com.stroygen.urdis2.dto.story.StoryUpdateDto;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.repository.MemberRepository;
import com.stroygen.urdis2.repository.StoryRepository;
import com.stroygen.urdis2.service.MemberService;
import com.stroygen.urdis2.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final MemberRepository memberRepository;

    @Override
    public Long saveBaseStory(BaseStorySaveRequestDto saveRequest) {
        Story onlyBaseStory = Story.builder().baseStory(saveRequest.getBaseStory()).build();
        Story savedStory = storyRepository.save(onlyBaseStory);
        return savedStory.getId();
    }
}
