package com.stroygen.urdis2.storySource.repository;

import com.stroygen.urdis2.storySource.entity.StorySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorySourceRepository extends JpaRepository<StorySource, Long> {
    Optional<StorySource> getByStorySourceId(Long storySourceId);
}
