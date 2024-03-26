package br.ueg.progweb1.lbbookstore.exception;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import lombok.Getter;

public @Getter class BusinessLogicException extends RuntimeException{
    private ErrorValidation error;
    public BusinessLogicException(String message, Throwable e){
        super(message, e);
        this.error = ErrorValidation.GENERAL;
    }
    public BusinessLogicException(String message){
        super(message);
        this.error = ErrorValidation.GENERAL;
    }
    public BusinessLogicException(ErrorValidation error){
        super(error.getMessage());
        this.error = error;
    }

}
