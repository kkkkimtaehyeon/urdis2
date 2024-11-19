package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.page.PageResponse;
import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;
import com.stroygen.urdis2.entity.page.StoryPage;
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
    public ResponseEntity<PageSaveResponse> createPage(@PathVariable("storyId") Long storyId,
                                                     @RequestBody PageSaveRequest pageSaveRequest) {
        PageSaveResponse pageSaveResponse = storyPageService.save(storyId, pageSaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pageSaveResponse);
    }

    @GetMapping("/{pageNumber}")
    public ResponseEntity<PageResponse> readPage(@PathVariable("storyId") Long storyId,
                                                 @PathVariable("pageNumber") Integer pageNumber) {
        PageResponse pageResponse = storyPageService.getStoryPage(storyId, pageNumber);
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }
}
