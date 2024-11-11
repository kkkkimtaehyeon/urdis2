package com.stroygen.urdis2.storyPage.entity;

import com.stroygen.urdis2.story.entity.Story;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class StoryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyPageId;
    //private String imageUrl;
    private Integer story_page_number;
    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;
}
