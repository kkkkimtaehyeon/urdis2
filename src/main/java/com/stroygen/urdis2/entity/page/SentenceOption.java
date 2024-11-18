package com.stroygen.urdis2.entity.page;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class SentenceOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sentenceOptionId;
    private String sentence;
    private int sentenceNumber;
    @ManyToOne
    @JoinColumn(name = "story_page_id")
    private StoryPage storyPage;

    public SentenceOption(String sentence, int sentenceNumber, StoryPage storyPage) {
        this.sentence = sentence;
        this.sentenceNumber = sentenceNumber;
        this.storyPage = storyPage;
    }
}
