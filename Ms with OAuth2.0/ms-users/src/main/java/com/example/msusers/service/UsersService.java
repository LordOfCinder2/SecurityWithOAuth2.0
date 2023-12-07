package com.example.msusers.service;

import com.example.msusers.domain.Users;
import com.example.msusers.repository.KeycloakUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final KeycloakUsersRepository keycloakUsersRepository;

    public Users findById(String id){
        return keycloakUsersRepository.findById(id);
    }


}
