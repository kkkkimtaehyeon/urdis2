package com.stroygen.urdis2.repository;

import com.stroygen.urdis2.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
        List<Story> findAllByMemberId(Long memberId);
}
