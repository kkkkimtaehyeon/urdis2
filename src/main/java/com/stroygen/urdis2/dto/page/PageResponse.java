package com.stroygen.urdis2.dto.page;

import lombok.Getter;

@Getter
public class PageResponse {
    private int pageNumber;
    private String content;

    public PageResponse(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }
}
