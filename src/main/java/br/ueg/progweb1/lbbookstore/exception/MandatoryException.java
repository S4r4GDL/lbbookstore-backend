package br.ueg.progweb1.lbbookstore.exception;

public class MandatoryException extends RuntimeException{
    public MandatoryException(String message){
        super(message);
    }
}
