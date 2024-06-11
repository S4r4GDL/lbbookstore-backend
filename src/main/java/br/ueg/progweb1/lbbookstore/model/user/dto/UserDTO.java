package br.ueg.progweb1.lbbookstore.model.user.dto;

import br.ueg.progweb1.lbbookstore.model.user.Login;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

public record UserDTO(
        Long id,
        String name,
        String email,
        Login login,
        LocalDate dataCreate,
        LocalDate lastUpdate
) {
}
