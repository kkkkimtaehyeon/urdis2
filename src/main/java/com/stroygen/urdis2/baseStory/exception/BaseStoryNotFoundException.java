package com.stroygen.urdis2.baseStory.exception;

public class BaseStoryNotFoundException extends RuntimeException{

    public BaseStoryNotFoundException(Long baseStoryId) {
        super(String.format("base story id (%s) not found!", baseStoryId));
    }
}
