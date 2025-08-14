package com.project.devxhub_Intern.exceptionHandler;

import com.project.devxhub_Intern.error.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Message> handleValidationErrors(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String message = error.getDefaultMessage();
            errorMessage.append(message).append("; ");
        });

        String finalMessage = errorMessage.toString().trim();
        if (finalMessage.endsWith(";")) {
            finalMessage = finalMessage.substring(0, finalMessage.length() - 1);
        }

        Message response = new Message("error", finalMessage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
