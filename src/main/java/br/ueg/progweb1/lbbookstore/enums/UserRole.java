package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    USER(1L, "User"),
    ADMIN(2L, "Admin");

    private Long roleCode;
    private String roleName;

    UserRole(Long roleCode, String roleName){
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}
