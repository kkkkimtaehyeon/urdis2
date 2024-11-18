package com.stroygen.urdis2.exception;

public class StoryNotFoundException extends RuntimeException{
    public StoryNotFoundException(Long storyId) {
        super(String.format("존재하지 않는 동화(%s)입니다. "));
    }
}
