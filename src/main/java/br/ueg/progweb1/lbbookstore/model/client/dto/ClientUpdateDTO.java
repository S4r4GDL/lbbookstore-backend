package br.ueg.progweb1.lbbookstore.model.client.dto;

import br.ueg.progweb1.lbbookstore.model.user.Login;

import java.time.LocalDate;

public record ClientUpdateDTO(String name,
                              String email,
                              Login login,
                              Long phoneNumber,
                              Long nationalRegisterNumber,
                              LocalDate dataBirth) {
}
