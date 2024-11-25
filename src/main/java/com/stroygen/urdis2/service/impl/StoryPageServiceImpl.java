package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.page.PageResponse;
import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;
import com.stroygen.urdis2.dto.page.Sentence;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.entity.page.SentenceOption;
import com.stroygen.urdis2.entity.page.StoryPage;
import com.stroygen.urdis2.exception.StoryPageNotFoundException;
import com.stroygen.urdis2.repository.SentenceOptionRepository;
import com.stroygen.urdis2.repository.StoryPageRepository;
import com.stroygen.urdis2.repository.StoryRepository;
import com.stroygen.urdis2.service.StoryPageService;
import com.stroygen.urdis2.service.StoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoryPageServiceImpl implements StoryPageService {
    private final StoryPageRepository storyPageRepository;
    private final SentenceOptionRepository sentenceOptionRepository;
    private final StoryService storyService;
    private final StoryRepository storyRepository;

    @Transactional
    @Override
    public PageSaveResponse save(Long storyId, PageSaveRequest pageSaveRequest) {
        Story story = storyService.getStory(storyId);

        StoryPage storyPage = storyPageRepository.save(pageSaveRequest.toEntity(story));

        for (Sentence sentence: pageSaveRequest.getOptions()) {
            SentenceOption sentenceOption = new SentenceOption(sentence.getSentence(), sentence.getIndex(), storyPage);
            sentenceOptionRepository.save(sentenceOption);
        }
        return new PageSaveResponse(storyPage.getContent());
    }

    @Override
    public PageResponse getStoryPage(Long storyId, int pageNumber) {
        Story story = storyService.getStory(storyId);
        Optional<StoryPage> optionalStoryPage = storyPageRepository.findByPageNumberAndStory(pageNumber, story);

        if (optionalStoryPage.isPresent()) {
            StoryPage storyPage = optionalStoryPage.get();
            return storyPage.toResponseDto();
        }

        throw new StoryPageNotFoundException(storyId, pageNumber);
    }
}
