package com.dakual.springdemo.service.impl;

import com.dakual.springdemo.model.User;
import com.dakual.springdemo.repository.UserRepository;
import com.dakual.springdemo.service.UserService;
import com.dakual.springdemo.util.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        user.setCreatedAt(new Date());
        user.setCreatedBy("dakual");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }

        throw new UserNotFoundException("User not found.");
    }

    @Override
    public User updateUserById(String id, User user) {
        Optional<User> resultUser = userRepository.findById(id);
        if(resultUser.isPresent()) {
            resultUser.get().setName(user.getName());
            resultUser.get().setSurname(user.getSurname());
            resultUser.get().setCreatedAt(new Date());
            resultUser.get().setCreatedBy("system-01");

            return userRepository.save(resultUser.get());
        }

        return null;
    }

    @Override
    public Page<User> pagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public Slice<User> slicePagination(Pageable page) {
        return userRepository.findAll(page);
    }
}
