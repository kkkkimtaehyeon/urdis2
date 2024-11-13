package com.stroygen.urdis2.baseStory.controller;

import com.stroygen.urdis2.story.service.StoryServiceImpl;
import com.stroygen.urdis2.baseStory.dto.StorySourceResponseDto;
import com.stroygen.urdis2.baseStory.dto.BaseStorySaveRequestDto;
import com.stroygen.urdis2.baseStory.service.StorySourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/base-stories")
@RestController
public class BaseStoryController {

    private final StorySourceService storySourceService;
    private final StoryServiceImpl storyServiceImpl;

    @PostMapping
    public ResponseEntity<StorySourceResponseDto> createBaseStory(@Valid @RequestBody BaseStorySaveRequestDto saveDto) {

        Long storySourceId = storySourceService.save(saveDto);
        Long storyId = storyServiceImpl.saveSourceIdOnStory(storySourceId);
        return new ResponseEntity<>(new StorySourceResponseDto(storyId), HttpStatus.OK);
    }
}
