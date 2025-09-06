package com.personal.budgetApp.Exceptions;

import com.personal.budgetApp.Controller.BudgetController;
import com.personal.budgetApp.Controller.TransactionsController;
import com.personal.budgetApp.Controller.UserController;
import com.personal.budgetApp.Response.ErrorResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(
    assignableTypes = {UserController.class, BudgetController.class, TransactionsController.class})
public class ControllerExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(
      BadRequestException requestException) {
    return ResponseEntity.badRequest()
        .body(ErrorResponse.builder().code("1000").description("Error in request").build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleNotValidException(MethodArgumentNotValidException ex) {
    List<Object> errorDetails =
        Collections.singletonList(
            ex.getBindingResult().getFieldErrors().stream()
                .map(
                    fieldError ->
                        Map.of(
                            "Field: ",
                            fieldError.getField(),
                            "Message: ",
                            fieldError.getDefaultMessage()))
                .toList());

    ErrorResponse errorResponse =
        ErrorResponse.builder()
            .code("4000")
            .description("Invalid Request")
            .detail(errorDetails)
            .build();

    return ResponseEntity.badRequest().body(errorResponse);
  }
}
