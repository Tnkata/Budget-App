package com.personal.budgetApp.Utils;

import static com.personal.budgetApp.Utils.PasswordUtil.hashPassword;

import com.personal.budgetApp.DBEntity.User;
import com.personal.budgetApp.Request.User.CreateUserRequest;

public class BuilderUtil {

  public static User buildDBDetails(CreateUserRequest createUserRequest) {
    String hashedPassword = hashPassword(createUserRequest.getPassword());

    return User.builder()
        .accountId(ValidationUtil.generateAccountId())
        .firstName(createUserRequest.getFirstName())
        .lastName(createUserRequest.getLastName())
        .username(createUserRequest.getUserName())
        .email(createUserRequest.getEmail())
        .password(hashedPassword)
        .dateOfBirth(createUserRequest.getDateOfBirth())
        .phoneNumber(createUserRequest.getPhoneNumber())
        .currency(createUserRequest.getCurrency())
        .income(createUserRequest.getIncome())
        .monthlyBudget(createUserRequest.getMonthlyBudget())
        .timezone(createUserRequest.getTimezone())
        .build();
  }
}
