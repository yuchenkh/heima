package org.example.heima.userservice.service;

import lombok.RequiredArgsConstructor;
import org.example.heima.userservice.entity.User;
import org.example.heima.userservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

// Sep 8, 2021
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public User getById(Long id) {
        return mapper.getById(id);
    }

}
