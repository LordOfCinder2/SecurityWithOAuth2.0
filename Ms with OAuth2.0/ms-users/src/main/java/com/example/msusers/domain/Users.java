package com.example.msusers.domain;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Users {


        private String idUser;

        private String username;

        private String email;

        private String firstName;

        private List<Bill> bills;

    //esta entidad la modelan ustedes de acuerdo a los atributos que vayan a necesitar
}
