package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.story.StoryBaseRequest;
import com.stroygen.urdis2.dto.story.StoryBaseResponse;
import com.stroygen.urdis2.dto.story.StorySaveDto;
import com.stroygen.urdis2.entity.Story;
import com.stroygen.urdis2.service.StoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/stories")
@RestController
public class StoryController {
    private final StoryService storyService;

    @PutMapping("/{storyId}")
    public ResponseEntity<Story> saveStory(@PathVariable("storyId") Long storyId,
                                    @RequestBody StorySaveDto storySaveDto) {
        Story savedStory = storyService.finalizeStory(storyId, storySaveDto);
        return ResponseEntity.status(HttpStatus.OK).body(savedStory);
    }

    @DeleteMapping("/{storyId}")
    public ResponseEntity<Void> removeStory(@PathVariable("storyId") Long storyId) {
        storyService.removeStory(storyId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<StoryBaseResponse> saveBaseStory(@Valid @RequestBody StoryBaseRequest storyBaseRequest) {

        StoryBaseResponse response = storyService.saveBaseStory(storyBaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{storyId}")
    public ResponseEntity<Story> getStory(@PathVariable("storyId") Long storyId) {
        Story story = storyService.getStory(storyId);
        return ResponseEntity.status(HttpStatus.OK).body(story);
    }

//    @GetMapping
//    public ResponseEntity<?> getStories(@RequestParam int page,
//                                        @RequestParam(name = "size", required = false, defaultValue = "10") int size,
//                                        @RequestParam String direction,
//                                        @RequestParam String property) {
//    }




//    @GetMapping("/me")
//    public ResponseEntity<List<Story>> getMemberStories(@AuthenticationPrincipal OAuth2User oAuth2User) {
//
//    }

}
