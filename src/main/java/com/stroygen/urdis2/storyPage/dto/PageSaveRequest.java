package com.stroygen.urdis2.storyPage.dto;

import com.stroygen.urdis2.story.entity.Story;
import com.stroygen.urdis2.storyPage.entity.SentenceOption;
import com.stroygen.urdis2.storyPage.entity.StoryPage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class PageSaveRequest {
    private Integer pageNumber;
    private List<Sentence> options;
    private Sentence selected;

    public StoryPage toStoryPageEntity(Story story) {
        return new StoryPage(this.pageNumber, selected.getSentence(), story);
    }

    public List<SentenceOption> toSentenceOptionEntities(StoryPage storyPage) {
        List<SentenceOption> sentenceOptions = new ArrayList<>();
        for (Sentence sentence: options) {
            sentenceOptions.add(new SentenceOption(sentence.getSentence(), sentence.getIndex(), storyPage));
        }
        return sentenceOptions;
    }
}

