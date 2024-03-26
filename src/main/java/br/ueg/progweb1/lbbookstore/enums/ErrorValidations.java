package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum ErrorValidations {

    GENERAL(0L, "Undefined error!"),
    INVALID_INFORMATION(400L, "Invalid Information!"),
    NOT_FOUND(404L, "Not found!"),
    MANDATORY_FIELD_VIOLATION(3L, "Mandatory field not filled!");

    private Long code;
    private String message;

    ErrorValidations(Long code, String message){
        this.code = code;
        this.message = message;
    }
}
