package br.ueg.progweb1.lbbookstore.model.client.dto;

import br.ueg.progweb1.lbbookstore.model.user.Login;

import java.time.LocalDate;

public record ClientUpdateDTO(String name,
                              String username,
                              String password,
                              LocalDate dataBirth,
                              Integer score) {
}
