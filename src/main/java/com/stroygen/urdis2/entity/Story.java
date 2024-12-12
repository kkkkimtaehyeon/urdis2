package com.stroygen.urdis2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long id;

    @Column(length = 50)
    private String title;
    private LocalDateTime createdAt;
    private Integer likeCount = 0;
    private Integer viewCount = 0;
    private Boolean isPublic = false;
    private String baseStory;
    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
    private List<StoryPage> pageList;


    @Builder
    public Story(Long id, String title, LocalDateTime createdAt, Integer likeCount, Integer viewCount, Boolean isPublic, String baseStory) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.isPublic = isPublic;
        this.baseStory = baseStory;
        this.pageList = new ArrayList<>();
    }

    public void addPage(StoryPage page) {
        pageList.add(page);
        page.setStory(this);
    }
}

