package com.bh.hhplus_week_02.business.dto;

public record UserDto(Long userId, String name, int grade){

    public UserDto(Long userId, String name, int grade) {
        this.userId = userId;
        this.name = name;
        this.grade = grade;
    }
}
