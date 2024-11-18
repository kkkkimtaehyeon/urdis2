package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.entity.page.StoryPage;
import com.stroygen.urdis2.repository.StoryPageRepository;
import com.stroygen.urdis2.service.StoryPageService;
import com.stroygen.urdis2.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoryPageServiceImpl implements StoryPageService {
    private final StoryPageRepository storyPageRepository;
    private final StoryService storyService;

    @Override
    public void save(long storyId, PageSaveRequest pageSaveRequest) {
        Story story = storyService.getStory(storyId);

        StoryPage storyPage = storyPageRepository.save(pageSaveRequest.toStoryPageEntity(story));
        //TODO: 문장 선택지 레포지토리 저장


    }
}
