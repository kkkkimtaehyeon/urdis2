package com.stroygen.urdis2.repository;

import com.stroygen.urdis2.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
