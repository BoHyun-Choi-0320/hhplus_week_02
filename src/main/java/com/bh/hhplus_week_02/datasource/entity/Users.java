package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name="userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private int grade;
}
