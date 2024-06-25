package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="\"User\"")
@Getter
public class User {
    @Id
    @Column(name="userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private int grade;
}
