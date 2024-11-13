package com.stroygen.urdis2.storyPage.dto;

import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.storyPage.entity.StoryPage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SentenceSaveRequestDto {
    private int pageNumber;
    private String pageContent;
    private Story story;

    public SentenceSaveRequestDto(int pageNumber, String pageContent, Story story) {
        this.pageNumber = pageNumber;
        this.pageContent = pageContent;
        this.story = story;
    }

    public StoryPage toEntity() {
        return StoryPage.builder()
                .story_page_number(this.pageNumber)
                .story_page_content(this.pageContent)
                .story(story)
                .build();
    }
}
