package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.page.PageResponse;
import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;

public interface StoryPageService {

    PageSaveResponse save(Long storyId, PageSaveRequest pageSaveRequest);
    PageResponse getStoryPage(Long storyId, int pageNumber);
}
