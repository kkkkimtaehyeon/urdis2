package com.stroygen.urdis2.entity;

import com.stroygen.urdis2.dto.page.PageResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
public class StoryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_page_id")
    private Long storyPageId;

    private Integer pageNumber;

    private String content;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id", referencedColumnName = "story_id")
    private Story story;

    public StoryPage(Integer pageNumber, String content, Story story) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.story = story;
    }

    public PageResponse toResponseDto() {
        return new PageResponse(this.pageNumber, this.content);
    }

}
