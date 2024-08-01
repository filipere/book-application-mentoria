package com.bookapplication.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

//    @ExceptionHandler({ChangeSetPersister.NotFoundException.class})
//    public ResponseEntity<Object> notFoundException(Exception exception, WebRequest request) {
//        ExcetionResponse excetionResponse = new ExcetionResponse(new Date(),
//                "Não encontrado",
//                request.getDescription(false));
//        return new ResponseEntity<>(excetionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({HttpClientErrorException.BadRequest.class})
//    public ResponseEntity<Object> badRequestException(Exception exception, WebRequest request) {
//        ExcetionResponse excetionResponse = new ExcetionResponse(new Date(),
//                "Erro na requisição",
//                request.getDescription(false));
//        return new ResponseEntity<>(excetionResponse, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExcetionResponse> internalServerError(Exception exception, WebRequest request) {
        ExcetionResponse excetionResponse = new ExcetionResponse(new Date(),
                        "Erro interno",
                        request.getDescription(false));
        return new ResponseEntity<>(excetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
