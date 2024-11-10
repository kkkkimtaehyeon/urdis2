package com.stroygen.urdis2.storySource.repository;

import com.stroygen.urdis2.storySource.entity.StorySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorySourceRepository extends JpaRepository<StorySource, Long> {
}
