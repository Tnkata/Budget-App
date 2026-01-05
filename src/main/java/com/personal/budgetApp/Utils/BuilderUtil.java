package com.personal.budgetApp.Utils;

import static com.personal.budgetApp.Utils.PasswordUtil.hashPassword;

import com.personal.budgetApp.Model.DBEntity.UserDTO;
import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.GetUserResponse;
import reactor.core.publisher.Mono;

public class BuilderUtil {

  public static UserDTO buildDBDetails(CreateUserRequest createUserRequest) {
    String hashedPassword = hashPassword(createUserRequest.getPassword());

    return UserDTO.builder()
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
        .balance("0")
        .build();
  }

  public static Mono<GetUserResponse> buildGetUserResponse(UserDTO userDTO) {

    return Mono.just(
        GetUserResponse.builder()
            .accountId(userDTO.getId())
            .firstName(userDTO.getFirstName())
            .lastName(userDTO.getLastName())
            .balance(userDTO.getBalance())
            .build());
  }
}
