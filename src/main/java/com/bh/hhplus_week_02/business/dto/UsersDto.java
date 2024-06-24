package com.bh.hhplus_week_02.business.dto;

public record UsersDto (Long userId, String name, int grade){

    public UsersDto(Long userId, String name, int grade) {
        this.userId = userId;
        this.name = name;
        this.grade = grade;
    }
}
