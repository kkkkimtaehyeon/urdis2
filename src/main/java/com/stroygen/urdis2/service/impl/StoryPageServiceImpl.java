package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;
import com.stroygen.urdis2.dto.page.Sentence;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.entity.page.SentenceOption;
import com.stroygen.urdis2.entity.page.StoryPage;
import com.stroygen.urdis2.repository.SentenceOptionRepository;
import com.stroygen.urdis2.repository.StoryPageRepository;
import com.stroygen.urdis2.service.StoryPageService;
import com.stroygen.urdis2.service.StoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoryPageServiceImpl implements StoryPageService {
    private final StoryPageRepository storyPageRepository;
    private final SentenceOptionRepository sentenceOptionRepository;
    private final StoryService storyService;

    @Transactional
    @Override
    public PageSaveResponse save(long storyId, PageSaveRequest pageSaveRequest) {
        Story story = storyService.getStory(storyId);

        StoryPage storyPage = storyPageRepository.save(pageSaveRequest.toStoryPageEntity(story));

        for (Sentence sentence: pageSaveRequest.getOptions()) {
            SentenceOption sentenceOption = new SentenceOption(sentence.getSentence(), sentence.getIndex(), storyPage);
            sentenceOptionRepository.save(sentenceOption);
        }
        return new PageSaveResponse(storyPage.getContent());
    }
}
