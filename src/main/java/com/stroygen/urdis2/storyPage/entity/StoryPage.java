package com.stroygen.urdis2.storyPage.entity;

import com.stroygen.urdis2.story.entity.Story;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class StoryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyPageId;
    //private String imageUrl;
    private Integer story_page_number;

    private String story_page_content;
    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;


    @Builder
    public StoryPage(Long storyPageId, Integer story_page_number, String story_page_content, Story story) {
        this.storyPageId = storyPageId;
        this.story_page_number = story_page_number;
        this.story_page_content = story_page_content;
        this.story = story;
    }
}
