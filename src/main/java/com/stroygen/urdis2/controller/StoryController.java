package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.baseStory.BaseStorySaveRequestDto;
import com.stroygen.urdis2.dto.story.StorySaveDto;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/stories")
@RestController
public class StoryController {
    private final StoryService storyService;

    @PostMapping("/base-stories")
    public ResponseEntity<?> saveBaseStory(@RequestBody BaseStorySaveRequestDto saveRequest) {
        long storyId = storyService.saveBaseStory(saveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(storyId);
    }

}
