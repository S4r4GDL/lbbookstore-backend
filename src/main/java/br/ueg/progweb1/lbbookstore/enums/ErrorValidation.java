package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum ErrorValidation {

    GENERAL(500L, "Undefined error!"),
    INVALID_ID(400L, "Invalid Id!"),
    NOT_FOUND(404L, "Not found!"),
    MANDATORY_FIELD_VIOLATION(3L, "Mandatory field must be filled up!"),
    INVALID_PRICE(4L, "The price must be higher than 0"),
    INVALID_QUANTITY(5L, "The quantity must be higher or equals to 0"),
    INVALID_QUANTITY_TO_DELETE(6L, "The quantity must be 0 so you can delete"),
    INVALID_YEAR(7L, "The year must be higher than 0 and lower than the current year"),
    INVALID_STATUS_TO_DELETE(8L, "The product must be inactive so you can delete");

    private Long code;
    private String message;

    ErrorValidation(Long code, String message){
        this.code = code;
        this.message = message;
    }
}
