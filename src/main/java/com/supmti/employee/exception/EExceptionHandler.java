package com.supmti.employee.exception;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class EExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public String handleNotFound(final ResponseStatusException exception, Model model) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(exception.getStatus().value());
        errorResponse.setException(exception.getClass().getSimpleName());
        errorResponse.setMessage(exception.getMessage());

        model.addAttribute("error", errorResponse);
        log.error("Exception HandlerError {}", errorResponse);
        return "error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValid(
            final MethodArgumentNotValidException exception, Model model) {
        final BindingResult bindingResult = exception.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors()
                .stream()
                .map(error -> {
                    final FieldError fieldError = new FieldError();
                    fieldError.setErrorCode(error.getCode());
                    fieldError.setField(error.getField());
                    return fieldError;
                })
                .collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setException(exception.getClass().getSimpleName());
        errorResponse.setFieldErrors(fieldErrors);
        errorResponse.setMessage(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());

        model.addAttribute("error", errorResponse);
        log.error("Exception HandlerError {}", errorResponse);
        return "error";
    }

    @ExceptionHandler(Throwable.class)
    public String handleThrowable(final Throwable exception, Model model) {
        exception.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setException(exception.getClass().getSimpleName());
        log.error(exception.getMessage());

        model.addAttribute("error", errorResponse);
        log.error("Exception HandlerError {}", errorResponse);
        return "error";
    }
}
