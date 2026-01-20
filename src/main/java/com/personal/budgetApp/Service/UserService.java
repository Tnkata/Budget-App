package com.personal.budgetApp.Service;

import com.personal.budgetApp.Exceptions.BadRequestException;
import com.personal.budgetApp.Model.DBEntity.UserDTO;
import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Request.User.UpdateUserRequest;
import com.personal.budgetApp.Model.Response.CreateUserResponse;
import com.personal.budgetApp.Model.Response.GetUserResponse;
import com.personal.budgetApp.Model.Response.UpdateUserResponse;
import com.personal.budgetApp.Repository.UserRepository;
import com.personal.budgetApp.Utils.BuilderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/** User Service Implementation class. Handles CRUD Service for Budgeting app. */
@Service
public class UserService {

  private final UserRepository userRepository;

  private static final Log log = LogFactory.getLog(UserService.class);

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Service to create new a User and store details in DB
   *
   * @param createUserRequest - User Request model
   * @param requestId - Request-Id to track request
   * @return - Returns CreateUserResponse model
   */
  public Mono<CreateUserResponse> createUserService(
      CreateUserRequest createUserRequest, final String requestId) {
    log.info("Creating new user service. ");

    return Mono.defer(
        () -> {
          UserDTO saved = userRepository.save(BuilderUtil.buildDBDetails(createUserRequest));

          return Mono.just(
              CreateUserResponse.builder()
                  .accountId(saved.getId())
                  .firstName(saved.getFirstName())
                  .lastName(saved.getLastName())
                  .email(saved.getEmail())
                  .currency(saved.getCurrency())
                  .build());
        });
  }

  /**
   * Service to fetch User details from store details in DB
   *
   * @param accountId - User's Account-Id
   * @param requestId - Request-Id to track request
   * @return - Returns GetUserResponse model
   */
  public Mono<GetUserResponse> getUserService(final String accountId, final String requestId) {
    return Mono.defer(
        () -> {
          if (userRepository.checkIfAccountIdExists(accountId).isPresent()) {

            return BuilderUtil.buildGetUserResponse(userRepository.getUserDetails(accountId));
          } else {
            return Mono.error(
                new BadRequestException(
                    "AccountId invalid", "Invalid accountId. User account details not found"));
          }
        });
  }

  /**
   * Service to fetch User details from store details in DB
   *
   * @param updateUserRequest - UpdateUserRequest Request model
   * @param requestId - Request-Id to track request
   * @return - Returns GetUserResponse model
   */
  public Mono<UpdateUserResponse> updateUserService(
      UpdateUserRequest updateUserRequest, final String requestId) {
    log.info("Inside updateUserService, Request-Id : {}" + requestId);

    return Mono.defer(
        () -> {
          if (userRepository.checkIfAccountIdExists(updateUserRequest.accountId()).isPresent()) {

            log.info("Account Found!");

            // TODO: Set up additional validations

            // TODO: Set up Builder Response.

            return null;
          }

          return null;
        });
  }
}
