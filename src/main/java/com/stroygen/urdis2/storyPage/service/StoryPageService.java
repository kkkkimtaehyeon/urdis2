package com.stroygen.urdis2.storyPage.service;

import com.stroygen.urdis2.storyPage.dto.SentenceSaveRequestDto;
import com.stroygen.urdis2.storyPage.entity.StoryPage;
import com.stroygen.urdis2.storyPage.repository.StoryPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoryPageService {
    private final StoryPageRepository storyPageRepository;

    public void savePageContent(SentenceSaveRequestDto sentenceSaveRequestDto) {
        StoryPage storyPage = storyPageRepository.save(sentenceSaveRequestDto.toEntity());
    }
}
