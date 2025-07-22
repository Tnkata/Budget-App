package com.personal.budgetApp.Request.User;

import static com.personal.budgetApp.Constants.ErrorMessageConstants.INVALID_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ErrorMessageConstants.PASSWORD_ERROR_MESSAGE;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;



@Builder
@Getter
@Setter
public class CreateUserRequest {

    @NotBlank(message = INVALID_ERROR_MESSAGE)
    private String firstName;

    @NotBlank(message = INVALID_ERROR_MESSAGE)
    private String lastName;

    @Email
    @NotBlank(message = INVALID_ERROR_MESSAGE)
    private String email;

    @NotBlank(message = INVALID_ERROR_MESSAGE)
    private String phoneNumber;

    private LocalDate dateOfBirth;

    @NotBlank()
    @Size(min = 8, message = PASSWORD_ERROR_MESSAGE)
    private String password; //TODO: Hash password before storage

    private String currency;

    private BigDecimal income;

    private BigDecimal monthlyBudget;

    private String timezone;




}
