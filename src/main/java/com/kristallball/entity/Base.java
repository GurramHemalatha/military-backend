package com.kristallball.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bases")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;
}