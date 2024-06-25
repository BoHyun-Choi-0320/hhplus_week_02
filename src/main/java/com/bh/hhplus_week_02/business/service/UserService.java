package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
