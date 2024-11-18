package com.stroygen.urdis2.storyPage.service;

import com.stroygen.urdis2.exception.StoryNotFoundException;
import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.service.StoryService;
import com.stroygen.urdis2.storyPage.dto.PageSaveRequest;
import com.stroygen.urdis2.storyPage.entity.StoryPage;
import com.stroygen.urdis2.storyPage.repository.StoryPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoryPageService {
    private final StoryPageRepository storyPageRepository;
    private final StoryService storyService;

    public void save(long storyId, PageSaveRequest pageSaveRequest) {
        Story story = storyService.getStory(storyId);

        StoryPage storyPage = storyPageRepository.save(pageSaveRequest.toStoryPageEntity(story));
        //TODO: 문장 선택지 레포지토리 저장


    }
}
