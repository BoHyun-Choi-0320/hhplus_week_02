package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.datasource.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsersRepository extends JpaRepository<Users, Long> {
}
