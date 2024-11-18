package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.service.StoryPageService;
import lombok.RequiredArgsConstructor;
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
