package com.personal.budgetApp.Service;

import com.personal.budgetApp.Exceptions.BadRequestException;
import com.personal.budgetApp.Model.DBEntity.UserDTO;
import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.CreateUserResponse;
import com.personal.budgetApp.Model.Response.GetUserResponse;
import com.personal.budgetApp.Repository.UserRepository;
import com.personal.budgetApp.Utils.BuilderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

  private final UserRepository userRepository;

  private static final Log log = LogFactory.getLog(UserService.class);

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Mono<CreateUserResponse> createUserService(CreateUserRequest createUserRequest) {
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

  public Mono<GetUserResponse> getUserService(final String accountId) {
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
}
