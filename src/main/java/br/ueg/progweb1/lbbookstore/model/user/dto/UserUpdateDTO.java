package br.ueg.progweb1.lbbookstore.model.user.dto;

import br.ueg.progweb1.lbbookstore.enums.UserRole;

public record UserUpdateDTO(Long id,
                            String name,
                            String userName,
                            String password,
                            UserRole role,
                            Boolean active) {

}
