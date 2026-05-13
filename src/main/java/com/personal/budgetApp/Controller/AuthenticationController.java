package com.personal.budgetApp.Controller;

import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.CreateUserResponse;
import com.personal.budgetApp.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

import static com.personal.budgetApp.Constants.ServiceConstants.AUTHORIZATION_SCOPE;
import static com.personal.budgetApp.Constants.ServiceConstants.CREATE_USER_ENDPOINT;
import static com.personal.budgetApp.Constants.ServiceConstants.REQUEST_ID;

@RestController
@RequestMapping(AUTHORIZATION_SCOPE)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private static final Log log = LogFactory.getLog(AuthenticationController.class);

    @PostMapping(CREATE_USER_ENDPOINT)
    public Mono<ResponseEntity<CreateUserResponse>> createUser(
            @Valid @RequestBody CreateUserRequest createUserRequest,
            @RequestHeader Map<String, String> headers) {
        log.info("Creating New User...");

        String requestId = headers.get(REQUEST_ID);

        return authenticationService
                .createUserService(createUserRequest, requestId)
                .map(
                        resp -> {
                            log.info("User created successfully");

                            return ResponseEntity.ok().body(resp);
                        });
    }
}
