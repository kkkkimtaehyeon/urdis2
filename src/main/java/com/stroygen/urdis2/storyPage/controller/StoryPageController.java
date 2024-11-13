package com.stroygen.urdis2.storyPage.controller;

import com.stroygen.urdis2.story.service.StoryServiceImpl;
import com.stroygen.urdis2.storyPage.service.StoryPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/stories/{storyId}/pages")
@RestController
public class StoryPageController {

    private final StoryPageService storyPageService;
    private final StoryServiceImpl storyServiceImpl;

    @PostMapping("/{pageNumber}")
    public ResponseEntity<?> savePageContent(
            @PathVariable("storyId") Long storyId,
            @PathVariable("pageNumber") int pageNumber,
            @RequestBody String selected) {

        return null;
    }
}
