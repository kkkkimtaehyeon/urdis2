package com.stroygen.urdis2.storySource.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class StorySource {
    public StorySource(String storySource) {
        this.storySource = storySource;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storySourceId;

    @Column(length = 1000, nullable = false)
    private String storySource;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
