package com.personal.budgetApp.Model.Request.User;

import static com.personal.budgetApp.Constants.ErrorMessageConstants.INVALID_ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ModelConstants.BALANCE;
import static com.personal.budgetApp.Constants.ModelConstants.CURRENCY;
import static com.personal.budgetApp.Constants.ModelConstants.DATE_OF_BIRTH;
import static com.personal.budgetApp.Constants.ModelConstants.EMAIL;
import static com.personal.budgetApp.Constants.ModelConstants.FIRST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.INCOME;
import static com.personal.budgetApp.Constants.ModelConstants.LAST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.MONTHLY_BUDGET;
import static com.personal.budgetApp.Constants.ModelConstants.PHONE_NUMBER;
import static com.personal.budgetApp.Constants.ModelConstants.TIMEZONE;
import static com.personal.budgetApp.Constants.ModelConstants.USER_NAME;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record UpdateUserRequest(
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty() String accountId,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(FIRST_NAME) String firstName,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(LAST_NAME) String lastName,
    @Email @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(EMAIL) String email,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(USER_NAME) String userName,
    @NotBlank(message = INVALID_ERROR_MESSAGE) @JsonProperty(PHONE_NUMBER) String phoneNumber,
    @JsonProperty(DATE_OF_BIRTH) String dateOfBirth,
    @JsonProperty(CURRENCY) String currency,
    @JsonProperty(INCOME) BigDecimal income,
    @JsonProperty(MONTHLY_BUDGET) BigDecimal monthlyBudget,
    @JsonProperty(TIMEZONE) String timezone,
    @JsonProperty(BALANCE) String balance) {

  public static UpdateUserRequestBuilder builder() {
    return new UpdateUserRequestBuilder();
  }

  public @NotBlank(message = INVALID_ERROR_MESSAGE) String getAccountId() {
    return this.accountId;
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

  public String getBalance() {
    return this.balance;
  }

  public static class UpdateUserRequestBuilder {
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String accountId;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String firstName;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String lastName;
    private @Email @NotBlank(message = INVALID_ERROR_MESSAGE) String email;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String userName;
    private @NotBlank(message = INVALID_ERROR_MESSAGE) String phoneNumber;
    private String dateOfBirth;
    private String currency;
    private BigDecimal income;
    private BigDecimal monthlyBudget;
    private String timezone;
    private String balance;

    UpdateUserRequestBuilder() {}

    public UpdateUserRequestBuilder accountId(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String accountId) {
      this.accountId = accountId;
      return this;
    }

    public UpdateUserRequestBuilder firstName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String firstName) {
      this.firstName = firstName;
      return this;
    }

    public UpdateUserRequestBuilder lastName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UpdateUserRequestBuilder email(
        @Email @NotBlank(message = INVALID_ERROR_MESSAGE) String email) {
      this.email = email;
      return this;
    }

    public UpdateUserRequestBuilder userName(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String userName) {
      this.userName = userName;
      return this;
    }

    public UpdateUserRequestBuilder phoneNumber(
        @NotBlank(message = INVALID_ERROR_MESSAGE) String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public UpdateUserRequestBuilder dateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public UpdateUserRequestBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public UpdateUserRequestBuilder income(BigDecimal income) {
      this.income = income;
      return this;
    }

    public UpdateUserRequestBuilder monthlyBudget(BigDecimal monthlyBudget) {
      this.monthlyBudget = monthlyBudget;
      return this;
    }

    public UpdateUserRequestBuilder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    public UpdateUserRequestBuilder balance(String balance) {
      this.balance = balance;
      return this;
    }

    public UpdateUserRequest build() {
      return new UpdateUserRequest(
          this.accountId,
          this.firstName,
          this.lastName,
          this.email,
          this.userName,
          this.phoneNumber,
          this.dateOfBirth,
          this.currency,
          this.income,
          this.monthlyBudget,
          this.timezone,
          this.balance);
    }

    public String toString() {
      return "UpdateUserRequest.UpdateUserRequestBuilder(accountId="
          + this.accountId
          + ", firstName="
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
          + ", currency="
          + this.currency
          + ", income="
          + this.income
          + ", monthlyBudget="
          + this.monthlyBudget
          + ", timezone="
          + this.timezone
          + ", balance="
          + this.balance
          + ")";
    }
  }
}
