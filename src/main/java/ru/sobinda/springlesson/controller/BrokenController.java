package ru.sobinda.springlesson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.sobinda.springlesson.domain.Person;

@RestController
@RequestMapping("/error")
public class BrokenController {

    @GetMapping("/error")
    public String error() {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }

    //выбрасываем и обрабатываем ошибку
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
        }
    }


    @GetMapping("/iae")
    public Person throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }


    //Обрабатываем конкретные ошибки во всех методах данного контроллера
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> iaeHandler(IllegalArgumentException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> reHandler(RuntimeException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
    }
}
