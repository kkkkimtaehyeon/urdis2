package com.stroygen.urdis2.storyPage.repository;

import com.stroygen.urdis2.storyPage.entity.StoryPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryPageRepository extends JpaRepository<StoryPage, Long> {
}
