package com.stroygen.urdis2.dto.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageSaveResponse {
    private String selectedSentence;

    public PageSaveResponse(String selectedSentence) {
        this.selectedSentence = selectedSentence;
    }
}
