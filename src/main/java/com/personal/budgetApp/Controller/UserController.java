package com.personal.budgetApp.Controller;

import static com.personal.budgetApp.Constants.ServiceConstants.CREATE_USER_ENDPOINT;
import static com.personal.budgetApp.Constants.ServiceConstants.GET_USER_ENDPOINT;
import static com.personal.budgetApp.Constants.ServiceConstants.USER_CONTROLLER_SCOPE;

import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.CreateUserResponse;
import com.personal.budgetApp.Model.Response.GetUserResponse;
import com.personal.budgetApp.Service.BudgetService;
import com.personal.budgetApp.Service.TransactionService;
import com.personal.budgetApp.Service.UserService;
import jakarta.validation.Valid;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(USER_CONTROLLER_SCOPE)
public class UserController {

  private final UserService userService;
  private final BudgetService budgetService;
  private final TransactionService transactionService;

  private static final Log log = LogFactory.getLog(UserController.class);

  public UserController(
      UserService userService, BudgetService budgetService, TransactionService transactionService) {
    this.userService = userService;
    this.budgetService = budgetService;
    this.transactionService = transactionService;
  }

  @PostMapping(CREATE_USER_ENDPOINT)
  public Mono<ResponseEntity<CreateUserResponse>> createUser(
      @Valid @RequestBody CreateUserRequest createUserRequest) {
    log.info("Creating New User...");

    return userService
        .createUserService(createUserRequest)
        .map(
            resp -> {
              log.info("User created successfully");

              return ResponseEntity.ok().body(resp);
            });
  }

  @GetMapping(GET_USER_ENDPOINT)
  public Mono<ResponseEntity<GetUserResponse>> getUser(
      @PathVariable final String accountId, @RequestHeader Map<String, String> headers) {
    log.info("Retrieving User Information...");

    return userService
        .getUserService(accountId)
        .map(
            getUserResponse -> {
              log.info("User Information Retrieved Successfully");

              return ResponseEntity.ok().body(getUserResponse);
            });
  }
}
