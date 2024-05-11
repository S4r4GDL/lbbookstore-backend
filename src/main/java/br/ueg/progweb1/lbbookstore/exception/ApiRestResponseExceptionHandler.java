package br.ueg.progweb1.lbbookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiRestResponseExceptionHandler {

    @ExceptionHandler({MandatoryException.class})
    public ResponseEntity<Object> handleMandatoryException(final MandatoryException e) {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body( e.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> handleBusinessException(final BusinessException e) {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body(e.getMessage());
    }


    @ExceptionHandler({ModelDataException.class})
    public ResponseEntity<Object> handleModelDataException(final ModelDataException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleException(final Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

}
