package com.mikhalenok.monitor.sensors.exception.handler;

import com.mikhalenok.monitor.sensors.dto.error.ExceptionErrorRs;
import com.mikhalenok.monitor.sensors.dto.error.ExceptionListRs;
import com.mikhalenok.monitor.sensors.dto.error.ExceptionStructuredRs;
import com.mikhalenok.monitor.sensors.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionListRs onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<ExceptionStructuredRs> error = e.getBindingResult().getFieldErrors().stream()
                .map(s -> new ExceptionStructuredRs(s.getField(), s.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ExceptionListRs(error);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ExceptionErrorRs> onConstraintViolationException(
            ConstraintViolationException e) {
        return  List.of(new ExceptionErrorRs(e.getMessage()));
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionErrorRs handleNotFoundException(NotFoundException exception) {
        return new ExceptionErrorRs(exception.getMessage());
    }
}
