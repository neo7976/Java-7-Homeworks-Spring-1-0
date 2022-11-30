package ru.sobinda.springlesson.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Выносим наши ошибки и можем указывать, какие пакеты/классы обрабатываются
//Используется, чтобы не дублировать код
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> iaeHandler(IllegalArgumentException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> reHandler(RuntimeException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
    }
}
