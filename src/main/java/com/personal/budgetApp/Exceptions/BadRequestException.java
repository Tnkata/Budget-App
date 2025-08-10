package com.personal.budgetApp.Exceptions;

import com.personal.budgetApp.Model.Error;
import com.personal.budgetApp.enums.ErrorCodes;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BadRequestException extends Exception {
    private Set<Error> errors;

    public BadRequestException(final String field, final String message) {
        super("Bad Request Exception Occurred!");
        Error error =
                new Error(
                        ErrorCodes.getFieldByValue(field).getCode(),
                        ErrorCodes.getFieldByValue(field).getMessage(),
                        ErrorCodes.getFieldByValue(field).getDetail()
                );
        errors.add(error);
    }
}
