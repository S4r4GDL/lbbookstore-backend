package br.ueg.progweb1.lbbookstore.model.user.dto;

import br.ueg.progweb1.lbbookstore.enums.UserRole;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String userName,
        Login login,
        UserRole role,
        LocalDate dataCreate,
        LocalDate lastUpdate
) {
}
