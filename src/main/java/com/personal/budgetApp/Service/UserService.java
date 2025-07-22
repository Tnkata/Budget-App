package com.personal.budgetApp.Service;

import com.personal.budgetApp.DBEntity.User;
import com.personal.budgetApp.Repository.UserRepository;
import com.personal.budgetApp.Request.User.CreateUserRequest;
import com.personal.budgetApp.Response.CreateUserResponse;
import com.personal.budgetApp.Utils.BuilderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Log log = LogFactory.getLog(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public Mono<CreateUserResponse> createUserService(CreateUserRequest createUserRequest) {
        log.info("Creating user service. ");

        return Mono.fromCallable(() -> {
            if(userRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
                throw new IllegalArgumentException("User Already exists");
            }

            User saved =  userRepository.save(BuilderUtil.buildDBDetails(createUserRequest, bCryptPasswordEncoder));

            return CreateUserResponse.builder()
                    .accountId(saved.getId())
                    .firstName(saved.getFirstName())
                    .lastName(saved.getLastName())
                    .email(saved.getEmail())
                    .currency(saved.getCurrency())
                    .build();
        });


    }
}
