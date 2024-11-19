package com.stroygen.urdis2.entity.page;

import com.stroygen.urdis2.entity.Story;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class StoryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_page_id")
    private Long storyPageId;
    @Column(name = "page_number")
    private Integer pageNumber;

    private String content;
    @ManyToOne
    @JoinColumn(name = "story_id", referencedColumnName = "story_id")
    private Story story;

    public StoryPage(Integer pageNumber, String content, Story story) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.story = story;
    }
}
