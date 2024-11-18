package com.stroygen.urdis2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class BaseStory {
    public BaseStory(String baseStory) {
        this.baseStory = baseStory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baseStoryId;

    @Column(length = 1000, nullable = false)
    private String baseStory;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
