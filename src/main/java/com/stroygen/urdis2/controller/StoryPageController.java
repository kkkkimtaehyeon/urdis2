package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;
import com.stroygen.urdis2.service.StoryPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/stories/{storyId}/pages")
@RestController
public class StoryPageController {

    private final StoryPageService storyPageService;

    @PostMapping
    public ResponseEntity<PageSaveResponse> savePage(@PathVariable("storyId") long storyId,
                                                     @RequestBody PageSaveRequest pageSaveRequest) {
        PageSaveResponse pageSaveResponse = storyPageService.save(storyId, pageSaveRequest);

        return ResponseEntity.status(HttpStatus.OK).body(pageSaveResponse);
    }
}
