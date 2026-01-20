package com.personal.budgetApp.Model.Request.User;

import static com.personal.budgetApp.Constants.ErrorMessageConstants.INVALID_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ErrorMessageConstants.PASSWORD_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ModelConstants.CURRENCY;
import static com.personal.budgetApp.Constants.ModelConstants.DATE_OF_BIRTH;
import static com.personal.budgetApp.Constants.ModelConstants.EMAIL;
import static com.personal.budgetApp.Constants.ModelConstants.FIRST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.INCOME;
import static com.personal.budgetApp.Constants.ModelConstants.LAST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.MONTHLY_BUDGET;
import static com.personal.budgetApp.Constants.ModelConstants.PASSWORD;
import static com.personal.budgetApp.Constants.ModelConstants.PHONE_NUMBER;
import static com.personal.budgetApp.Constants.ModelConstants.TIMEZONE;
import static com.personal.budgetApp.Constants.ModelConstants.USER_NAME;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CreateUserRequest(
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(FIRST_NAME) String firstName,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(LAST_NAME) String lastName,
    @Email @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(EMAIL) String email,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(USER_NAME) String userName,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(PHONE_NUMBER) String phoneNumber,
    @JsonProperty(DATE_OF_BIRTH) String dateOfBirth,
    @NotBlank(message = INVALID_ERROR_MESSAGE)
        @Size(min = 8, message = PASSWORD_ERROR_MESSAGE)
        @JsonProperty(PASSWORD)
        String password,
    @JsonProperty(CURRENCY) String currency,
    @JsonProperty(INCOME) BigDecimal income,
    @JsonProperty(MONTHLY_BUDGET) BigDecimal monthlyBudget,
    @JsonProperty(TIMEZONE) String timezone) {

  public static CreateUserRequestBuilder builder() {
    return new CreateUserRequestBuilder();
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) String getFirstName() {
    return this.firstName;
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) String getLastName() {
    return this.lastName;
  }

  public @Email @NotBlank(message = INVALID_ERROR_MESSAGE) String getEmail() {
    return this.email;
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) String getUserName() {
    return this.userName;
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getDateOfBirth() {
    return this.dateOfBirth;
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) @Size(min = 8, message = PASSWORD_ERROR_MESSAGE)
  String getPassword() {
    return this.password;
  }

  public String getCurrency() {
    return this.currency;
  }

  public BigDecimal getIncome() {
    return this.income;
  }

  public BigDecimal getMonthlyBudget() {
    return this.monthlyBudget;
  }

  public String getTimezone() {
    return this.timezone;
  }

  public static class CreateUserRequestBuilder {
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String firstName;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String lastName;
    private @Email @NotBlank(message = INVALID_ERROR_MESSAGE) String email;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String userName;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String phoneNumber;
    private String dateOfBirth;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) @Size(
        min = 8,
        message = PASSWORD_ERROR_MESSAGE) String password;
    private String currency;
    private BigDecimal income;
    private BigDecimal monthlyBudget;
    private String timezone;

    CreateUserRequestBuilder() {}

    public CreateUserRequestBuilder firstName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String firstName) {
      this.firstName = firstName;
      return this;
    }

    public CreateUserRequestBuilder lastName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String lastName) {
      this.lastName = lastName;
      return this;
    }

    public CreateUserRequestBuilder email(
        @Email @NotBlank(message = INVALID_ERROR_MESSAGE) String email) {
      this.email = email;
      return this;
    }

    public CreateUserRequestBuilder userName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String userName) {
      this.userName = userName;
      return this;
    }

    public CreateUserRequestBuilder phoneNumber(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public CreateUserRequestBuilder dateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public CreateUserRequestBuilder password(
        @NotBlank(message = INVALID_ERROR_MESSAGE) @Size(min = 8, message = PASSWORD_ERROR_MESSAGE)
            String password) {
      this.password = password;
      return this;
    }

    public CreateUserRequestBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public CreateUserRequestBuilder income(BigDecimal income) {
      this.income = income;
      return this;
    }

    public CreateUserRequestBuilder monthlyBudget(BigDecimal monthlyBudget) {
      this.monthlyBudget = monthlyBudget;
      return this;
    }

    public CreateUserRequestBuilder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    public CreateUserRequest build() {
      return new CreateUserRequest(
          this.firstName,
          this.lastName,
          this.email,
          this.userName,
          this.phoneNumber,
          this.dateOfBirth,
          this.password,
          this.currency,
          this.income,
          this.monthlyBudget,
          this.timezone);
    }

    public String toString() {
      return "CreateUserRequest.CreateUserRequestBuilder(firstName="
          + this.firstName
          + ", lastName="
          + this.lastName
          + ", email="
          + this.email
          + ", userName="
          + this.userName
          + ", phoneNumber="
          + this.phoneNumber
          + ", dateOfBirth="
          + this.dateOfBirth
          + ", password="
          + this.password
          + ", currency="
          + this.currency
          + ", income="
          + this.income
          + ", monthlyBudget="
          + this.monthlyBudget
          + ", timezone="
          + this.timezone
          + ")";
    }
  }
}
