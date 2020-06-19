package com.kablanfatih.issuemanagement.service.impl;

import com.kablanfatih.issuemanagement.entity.User;
import com.kablanfatih.issuemanagement.repository.UserRepository;
import com.kablanfatih.issuemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot bu null");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
