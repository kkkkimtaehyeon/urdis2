package com.stroygen.urdis2.story.service;

import com.stroygen.urdis2.story.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoryService {
    private final StoryRepository storyRepository;

}
