package com.example.msusers.controller;


import com.example.msusers.domain.Users;
import com.example.msusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    @GetMapping
    public ResponseEntity<Users> findByUserId(@RequestParam String id){
        return ResponseEntity.ok().body(usersService.findById(id));
    }
}
