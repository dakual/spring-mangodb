package com.dakual.springdemo.controller;

import java.util.List;
import java.util.Optional;

import com.dakual.springdemo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dakual.springdemo.repository.UserRepository;
import com.dakual.springdemo.model.User;

import lombok.Data;

@RestController
@Data
@RequestMapping("users")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        User result = userService.addUser(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> result = userService.getAllUsers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") String id, @RequestBody User user) {
        User result = userService.updateUserById(id, user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<User>> pagination(@RequestParam int page, @RequestParam int size) {
        Page<User> result = userService.pagination(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/page/v1")
    public ResponseEntity<Page<User>> pagination(Pageable page) {
        Page<User> result = userService.pagination(page);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/page/v2")
    public ResponseEntity<Slice<User>> slicePagination(Pageable page) {
        return ResponseEntity.ok(userService.slicePagination(page));
    }


}