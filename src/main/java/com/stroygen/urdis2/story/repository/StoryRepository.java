package com.stroygen.urdis2.story.repository;

import com.stroygen.urdis2.story.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
