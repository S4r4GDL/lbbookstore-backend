package br.ueg.progweb1.lbbookstore.model.client.dto;

import br.ueg.progweb1.lbbookstore.model.user.Login;

import java.time.LocalDate;

public record ClientCreateDTO(String title,
                              String email,
                              String password,
                              Long phoneNumber,
                              Long nationalRegisterNumber,
                              LocalDate dataBirth) {
}
