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
        .firstName(createUserRequest.firstName())
        .lastName(createUserRequest.lastName())
        .username(createUserRequest.userName())
        .email(createUserRequest.email())
        .password(hashedPassword)
        .dateOfBirth(createUserRequest.dateOfBirth())
        .phoneNumber(createUserRequest.phoneNumber())
        .currency(createUserRequest.currency())
        .income(createUserRequest.income())
        .monthlyBudget(createUserRequest.monthlyBudget())
        .timezone(createUserRequest.timezone())
        .balance("0.00")
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
