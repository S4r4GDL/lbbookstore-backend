package br.ueg.progweb1.lbbookstore.exception;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;

public class ModelDataException extends RuntimeException{
    private ErrorValidation error;
    public ModelDataException(String message, Throwable e){
        super(message, e);
        this.error = ErrorValidation.GENERAL;
    }
    public ModelDataException(String message){
        super(message);
        this.error = ErrorValidation.GENERAL;
    }
    public ModelDataException(ErrorValidation error){
        super(error.getMessage());
        this.error = error;
    }

}