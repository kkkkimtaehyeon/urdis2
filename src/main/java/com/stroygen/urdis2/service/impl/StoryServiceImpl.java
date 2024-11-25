package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.story.*;
import com.stroygen.urdis2.exception.MemberNotFoundException;
import com.stroygen.urdis2.exception.StoryNotFoundException;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.repository.MemberRepository;
import com.stroygen.urdis2.repository.StoryRepository;
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
    public Story getStory(Long storyId) {
        Optional<Story> optionalStory = storyRepository.findById(storyId);
        return optionalStory.orElseThrow(() -> new StoryNotFoundException(storyId));
    }

    @Override
    public List<Story> getStories(Long memberId) {
        if (memberRepository.existsById(memberId)) {
            throw new MemberNotFoundException(memberId);
        }
        return storyRepository.findAllByMemberId(memberId);
    }

    @Override
    public void removeStory(Long storyId) {
        Story story = getStory(storyId);

        storyRepository.delete(story);
    }

    @Override
    public Story modifyStory(StoryUpdateDto storyUpdateDto) {
        return null;
    }

    @Override
    public boolean isStoryExists(Long storyId) {
        return storyRepository.existsById(storyId);
    }

    @Override
    public Story finalizeStory(Long storyId, StorySaveDto storySaveDto) {
        Optional<Story> optionalStory = storyRepository.findById(storyId);
        if (optionalStory.isEmpty()) {
            throw new StoryNotFoundException(storyId);
        }

        Story story = optionalStory.get();
        Story finalStory = Story.builder()
                .storyId(story.getStoryId())
                .baseStory(story.getBaseStory())
                .createdAt(LocalDateTime.now())
                .viewCount(0)
                .likeCount(0)
                .storyTitle(storySaveDto.storyTitle())
                .isPublic(storySaveDto.isPublic())
                .build();

        return storyRepository.save(finalStory);
    }

    /** 동화생성 시작 시 기초 이야기만 저장해서 동화 id를 반환해줌*/
    @Override
    public StoryBaseResponse saveBaseStory(StoryBaseRequest request) {
        String baseStory = request.baseStory();;
        Story story = Story.builder()
                .baseStory(baseStory)
                .build();
        Story savedStory = storyRepository.save(story);

        return new StoryBaseResponse(baseStory, savedStory.getStoryId());
    }
}
