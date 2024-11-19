package com.stroygen.urdis2.entity.page;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class SentenceOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sentence_option_id")
    private Long sentenceOptionId;
    private String sentence;
    @Column(name = "sentence_number")
    private int sentenceNumber;
    @ManyToOne
    @JoinColumn(name = "story_page_id", referencedColumnName = "story_page_id")
    private StoryPage storyPage;

    public SentenceOption(String sentence, int sentenceNumber, StoryPage storyPage) {
        this.sentence = sentence;
        this.sentenceNumber = sentenceNumber;
        this.storyPage = storyPage;
    }
}
