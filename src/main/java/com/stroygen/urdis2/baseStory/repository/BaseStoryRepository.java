package com.stroygen.urdis2.baseStory.repository;

import com.stroygen.urdis2.baseStory.entity.BaseStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseStoryRepository extends JpaRepository<BaseStory, Long> {
    Optional<BaseStory> findByBaseStoryId(Long baseStoryId);

}
