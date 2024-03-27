package br.ueg.progweb1.lbbookstore.exception;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import lombok.Getter;

public @Getter class BusinessException extends RuntimeException{
    private ErrorValidation error;
    public BusinessException(String message, Throwable e){
        super(message, e);
        this.error = ErrorValidation.GENERAL;
    }
    public BusinessException(String message){
        super(message);
        this.error = ErrorValidation.GENERAL;
    }
    public BusinessException(ErrorValidation error){
        super(error.getMessage());
        this.error = error;
    }

}
