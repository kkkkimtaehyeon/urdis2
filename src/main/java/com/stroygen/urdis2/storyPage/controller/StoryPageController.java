package com.stroygen.urdis2.storyPage.controller;

import com.stroygen.urdis2.story.service.StoryService;
import com.stroygen.urdis2.storyPage.dto.PageSaveRequest;
import com.stroygen.urdis2.storyPage.service.StoryPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/stories/{storyId}/pages")
@RestController
public class StoryPageController {

    private final StoryPageService storyPageService;

    @PostMapping
    public void savePage(@PathVariable("storyId") long storyId,
                         @RequestBody PageSaveRequest pageSaveRequest) {


    }
}
