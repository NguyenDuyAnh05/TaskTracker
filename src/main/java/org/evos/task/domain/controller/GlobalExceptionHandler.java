package org.evos.task.domain.controller;

import org.evos.task.domain.dto.ErrorDto;
import org.evos.task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex){
    String errorMessage = ex.getBindingResult().getFieldErrors().stream()
        .findFirst()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .orElse("Validation Failed.");
    ErrorDto errorDto = new ErrorDto(errorMessage);

    return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<ErrorDto> handleTaskNotFoundException (TaskNotFoundException ex){
    UUID id = ex.getId();
    String errorMessage = String.format("Task with ID : '%s' not found", id);
    ErrorDto errorDto = new ErrorDto(errorMessage);

    return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
  }
}
