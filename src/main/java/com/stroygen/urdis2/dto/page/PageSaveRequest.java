package com.stroygen.urdis2.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageSaveRequest {
    private int pageNumber;
    private String content;
}

