package com.stroygen.urdis2.storySource.controller;

import com.stroygen.urdis2.storySource.dto.StorySourceDto;
import com.stroygen.urdis2.storySource.service.StorySourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/story-sources")
@RestController
public class StorySourceController {

    private final StorySourceService storySourceService;

    @PostMapping("/")
    public String createStorySource(@Valid @RequestBody StorySourceDto storySourceDto) {

        Long id = storySourceService.save(storySourceDto);
        return id.toString();
    }
}
