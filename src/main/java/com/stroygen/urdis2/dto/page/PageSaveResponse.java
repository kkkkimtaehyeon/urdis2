package com.stroygen.urdis2.dto.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageSaveResponse {
    private String selected;

    public PageSaveResponse(String selected) {
        this.selected = selected;
    }
}
