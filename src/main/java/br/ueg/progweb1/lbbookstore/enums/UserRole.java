package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    USER(1L, "ROLE_USER"),
    ADMIN(2L, "ROLE_ADMIN");

    private Long roleCode;
    private String Name;

    UserRole(Long roleCode, String roleName){
        this.roleCode = roleCode;
        this.Name = roleName;
    }
}
