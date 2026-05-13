package com.personal.budgetApp.Service;

import com.personal.budgetApp.Model.DBEntity.UserDTO;
import com.personal.budgetApp.Model.Request.User.CreateUserRequest;
import com.personal.budgetApp.Model.Response.CreateUserResponse;
import com.personal.budgetApp.Repository.UserRepository;
import com.personal.budgetApp.Utils.BuilderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.core.publisher.Mono;

import static java.lang.StringTemplate.STR;

public class AuthenticationService {

    private final UserRepository userRepository;

    AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static Log log = LogFactory.getLog(AuthenticationService.class);

    /**
     * Service to create new a User and store details in our postgres DB
     *
     * @param createUserRequest - User Request model
     * @param requestId - Request-Id to track request
     * @return - Returns CreateUserResponse model
     */
    public Mono<CreateUserResponse> createUserService(
            CreateUserRequest createUserRequest, final String requestId) {
        log.info(STR."Creating new user service. Request-Id : \{requestId}");

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
}
