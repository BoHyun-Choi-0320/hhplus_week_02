package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.datasource.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
