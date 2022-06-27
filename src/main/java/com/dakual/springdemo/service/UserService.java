package com.dakual.springdemo.service;

import com.dakual.springdemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {
    public abstract User addUser(User user);
    public abstract List<User> getAllUsers();
    public abstract User getUserById(String id);
    public abstract User updateUserById(String id, User user);
    public abstract Page<User> pagination(int page, int size);
    public abstract Page<User> pagination(Pageable page);
    public abstract Slice<User> slicePagination(Pageable page);
}
