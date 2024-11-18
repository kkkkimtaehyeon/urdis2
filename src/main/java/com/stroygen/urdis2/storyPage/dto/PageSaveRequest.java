package com.stroygen.urdis2.storyPage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PageSaveRequest {
    private Integer pageNumber;
    private List<Sentence> options;
    private Sentence selected;
}

