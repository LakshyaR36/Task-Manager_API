package com.vishal.taskmanager.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",
            nullable = false,
            length = 100
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            unique = true,
            length = 255
    )
    private String email;
    @Column(
            name = "password_hash",
            nullable = false
    )
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "role",
            nullable = false
    )
    private Role role;
    @CreationTimestamp
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(
            name = "updated_at",
            nullable = false
    )
    private LocalDateTime updatedAt;
}
