package com.stroygen.urdis2.storyPage.entity;

import com.stroygen.urdis2.story.entity.Story;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class StoryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyPageId;
    private Integer pageNumber;

    private String content;
    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    public StoryPage(Integer pageNumber, String content, Story story) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.story = story;
    }
}
