package com.stroygen.urdis2.dto.story;

import lombok.Getter;

public record StorySaveDto(String storyTitle, Boolean isPublic) {
}


//@Getter
//public class StorySaveDto {
//    private final String storyTitle;
//    private final boolean isPublic;
//
//    public StorySaveDto(String storyTitle, boolean isPublic) {
//        this.storyTitle = storyTitle;
//        this.isPublic = isPublic;
//    }
//}