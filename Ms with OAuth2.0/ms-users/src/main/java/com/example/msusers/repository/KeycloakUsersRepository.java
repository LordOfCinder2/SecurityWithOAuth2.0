package com.example.msusers.repository;

import com.example.msusers.domain.Users;
import com.example.msusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class KeycloakUsersRepository {

    private final Keycloak keycloakClient;
    private final FeignBillsRepository feignBillsRepository;

    @Value("${keycloakParams.keycloak.realm}")
    private String realm;

    public Users findById(String id){
        UserRepresentation userRepresentation = keycloakClient.realm(realm).users().get(id).toRepresentation();
        return toUser(userRepresentation);
    }

    public Users toUser(UserRepresentation userRepresentation){
        return new Users(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(),
                feignBillsRepository.findById(userRepresentation.getId()));
    }
}
