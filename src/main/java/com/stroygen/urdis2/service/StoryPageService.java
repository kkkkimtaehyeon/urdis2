package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.page.PageSaveRequest;
import com.stroygen.urdis2.dto.page.PageSaveResponse;

public interface StoryPageService {

    PageSaveResponse save(long storyId, PageSaveRequest pageSaveRequest);
}
