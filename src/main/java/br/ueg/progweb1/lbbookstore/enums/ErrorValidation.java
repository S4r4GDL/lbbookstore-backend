package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum ErrorValidation {

    GENERAL(0L, "Undefined error!"),
    INVALID_ID(400L, "Invalid Id!"),
    NOT_FOUND(404L, "Not found!"),
    MANDATORY_FIELD_VIOLATION(3L, "Mandatory field not filled!"),
    INVALID_PRICE(4L, "The price must be higher than 0"),
    INVALID_QUANTITY(5L, "The quantity must be higher or equals to 0"),
    INVALID_QUANTITY_TO_DELETE(6L, "The quantity must be 0 so you can delete");

    private Long code;
    private String message;

    ErrorValidation(Long code, String message){
        this.code = code;
        this.message = message;
    }
}
