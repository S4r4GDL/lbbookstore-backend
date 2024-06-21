package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    GUEST(1L, "Guest"),
    USER(2L, "User"),
    ADMIN(3L, "Admin");

    private Long roleCode;
    private String roleName;

    UserRole(Long roleCode, String roleName){
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}
