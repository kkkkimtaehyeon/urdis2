package com.stroygen.urdis2.repository;

import com.stroygen.urdis2.entity.page.StoryPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryPageRepository extends JpaRepository<StoryPage, Long> {
}
