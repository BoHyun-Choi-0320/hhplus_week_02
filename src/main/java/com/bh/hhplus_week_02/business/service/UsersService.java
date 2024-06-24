package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
