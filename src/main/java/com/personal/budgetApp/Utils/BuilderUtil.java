package com.personal.budgetApp.Utils;

import static com.personal.budgetApp.Constants.ServiceConstants.INITIAL_BALANCE;
import static com.personal.budgetApp.Utils.PasswordUtil.hashPassword;

import com.personal.budgetApp.Model.DBEntity.UserDTO;
import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.GetUserResponse;
import reactor.core.publisher.Mono;

/**
 * Utility class for mapping/building instances. Provides a fluent API to build objects with default
 * settings.
 */
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
        .balance(INITIAL_BALANCE)
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
