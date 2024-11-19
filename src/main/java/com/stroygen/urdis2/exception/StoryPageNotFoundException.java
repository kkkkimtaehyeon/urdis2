package com.stroygen.urdis2.exception;

public class StoryPageNotFoundException extends RuntimeException{
    public StoryPageNotFoundException(Long storyId, int pageNumber) {
        super(String.format("존재하지 않는 페이지입니다. 동화: %s, 페이지: %s", storyId, pageNumber));
    }
}
