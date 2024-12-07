package com.stroygen.urdis2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_birth")
    private LocalDate birth;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role", nullable = false)
    private Role role;


    @Builder
    public Member(Long id, String email, String name, LocalDate birth, LocalDateTime createdAt, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birth = birth;
        this.createdAt = createdAt;
        this.role = role;
    }
}
