package com.stroygen.urdis2.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;
    @Column(name = "member_email", nullable = false)
    private String email;
    @Column(name = "member_name", nullable = false)
    private String name;
    @Column(name = "member_birth")
    private String birth;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
