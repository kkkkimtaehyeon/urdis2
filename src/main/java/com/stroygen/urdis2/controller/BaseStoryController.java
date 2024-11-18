package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.baseStory.BaseStorySaveResponseDto;
import com.stroygen.urdis2.dto.baseStory.BaseStorySaveRequestDto;
import com.stroygen.urdis2.entity.BaseStory;
import com.stroygen.urdis2.service.BaseStoryService;
import com.stroygen.urdis2.dto.story.StoryInitializerDto;
import com.stroygen.urdis2.service.StoryService;
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

    private final BaseStoryService baseStoryService;
    private final StoryService storyService;

    @PostMapping
    public ResponseEntity<BaseStorySaveResponseDto> createBaseStory(@Valid @RequestBody BaseStorySaveRequestDto saveDto) {

        Long baseStoryId = baseStoryService.save(saveDto);
        BaseStory baseStory = baseStoryService.get(baseStoryId);

        Long storyId = storyService.initialize(new StoryInitializerDto(baseStory));
        BaseStorySaveResponseDto responseDto = new BaseStorySaveResponseDto(storyId, baseStory.getBaseStory());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
