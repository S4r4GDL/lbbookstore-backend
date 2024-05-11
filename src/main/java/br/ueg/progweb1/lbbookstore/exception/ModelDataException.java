package br.ueg.progweb1.lbbookstore.exception;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;

public class ModelDataException extends RuntimeException{
    public ModelDataException(ErrorValidation error){
        super(error.getMessage());
    }

}