package com.personal.budgetApp.Service;

import com.personal.budgetApp.DBEntity.User;
import com.personal.budgetApp.Exceptions.BadRequestException;
import com.personal.budgetApp.Repository.UserRepository;
import com.personal.budgetApp.Request.User.CreateUserRequest;
import com.personal.budgetApp.Response.CreateUserResponse;
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
          if (userRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
            return Mono.error(new BadRequestException("email", "User Already exists"));
          }

          User saved = userRepository.save(BuilderUtil.buildDBDetails(createUserRequest));

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
}
