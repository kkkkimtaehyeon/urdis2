package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.page.PageSaveRequest;

public interface StoryPageService {

    void save(long storyId, PageSaveRequest pageSaveRequest);
}
