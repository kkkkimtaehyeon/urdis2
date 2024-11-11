package com.stroygen.urdis2.storySource.controller;

import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.story.service.StoryService;
import com.stroygen.urdis2.storySource.dto.StorySourceResponseDto;
import com.stroygen.urdis2.storySource.dto.StorySourceSaveDto;
import com.stroygen.urdis2.storySource.service.StorySourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/story-sources")
@RestController
public class StorySourceController {

    private final StorySourceService storySourceService;
    private final StoryService storyService;

    @PostMapping("")
    public ResponseEntity<StorySourceResponseDto> createStorySource(@Valid @RequestBody StorySourceSaveDto saveDto) {

        Long storySourceId = storySourceService.save(saveDto);
        Long storyId = storyService.saveSourceIdOnStory(storySourceId);
        return new ResponseEntity<>(new StorySourceResponseDto(storyId), HttpStatus.OK);
    }
}
