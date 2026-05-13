package com.personal.budgetApp.Model.Request.User;

import static com.personal.budgetApp.Constants.ErrorMessageConstants.INVALID_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ErrorMessageConstants.PASSWORD_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ModelConstants.DATE_OF_BIRTH;
import static com.personal.budgetApp.Constants.ModelConstants.EMAIL;
import static com.personal.budgetApp.Constants.ModelConstants.FIRST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.LAST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.PASSWORD;
import static com.personal.budgetApp.Constants.ModelConstants.PHONE_NUMBER;
import static com.personal.budgetApp.Constants.ModelConstants.USER_NAME;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateUserRequest {

  @NotBlank(message = INVALID_ERROR_MESSAGE)
  @JsonProperty(FIRST_NAME)
  private String firstName;

  @NotBlank(message = INVALID_ERROR_MESSAGE)
  @JsonProperty(LAST_NAME)
  private String lastName;

  @Email
  @NotBlank(message = INVALID_ERROR_MESSAGE)
  @JsonProperty(EMAIL)
  private String email;

  @JsonProperty(USER_NAME)
  private String userName;

  // TODO: Update swagger with this field change
  @JsonProperty(PHONE_NUMBER)
  private String phoneNumber;

  // TODO: Update swagger with this field change
  @JsonProperty(DATE_OF_BIRTH)
  private String dateOfBirth;

  @NotBlank(message = INVALID_ERROR_MESSAGE)
  @Size(min = 8, message = PASSWORD_ERROR_MESSAGE)
  @JsonProperty(PASSWORD)
  private String password;
}
