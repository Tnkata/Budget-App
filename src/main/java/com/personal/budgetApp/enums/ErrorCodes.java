package com.personal.budgetApp.enums;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCodes {
  INTERNAL_ERROR(
      "2300",
      null,
      "Your request cannot be processed at this time. Please tyr again later.",
      "Internal Error",
      HttpStatus.INTERNAL_SERVER_ERROR),
  USER_EMAIL_ALREADY_EXIST(
      "1000", "email", "User Email already exists", "Invalid Request", HttpStatus.BAD_REQUEST),
  DEFAULT(
      "2050",
      "Unknown Field",
      "Invalid input was provided in the request",
      "Invalid Request",
      HttpStatus.BAD_REQUEST);

  private static final Map<String, ErrorCodes> ERROR_VALUE_LOOKUP = new HashMap<>();
  private static final Map<String, ErrorCodes> ERROR_CODE_LOOKUP = new HashMap<>();

  static {
    for (ErrorCodes key : values()) {
      ERROR_VALUE_LOOKUP.put((key.value), key);
    }
  }

  static {
    for (ErrorCodes key : values()) {
      ERROR_CODE_LOOKUP.put((key.code), key);
    }
  }

  private final String code;
  private final String value;
  private final String detail;
  private final String message;
  private final HttpStatus httpStatus;

  public static ErrorCodes getFieldByValue(final String value) {
    return ERROR_VALUE_LOOKUP.getOrDefault(value, DEFAULT);
  }
}
