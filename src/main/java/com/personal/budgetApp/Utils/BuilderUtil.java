package com.personal.budgetApp.Utils;

import com.personal.budgetApp.DBEntity.User;
import com.personal.budgetApp.Request.User.CreateUserRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BuilderUtil {

    public static User buildDBDetails(CreateUserRequest createUserRequest, BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .dateOfBirth(createUserRequest.getDateOfBirth())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .phoneNumber(createUserRequest.getPhoneNumber())
                .currency(createUserRequest.getCurrency())
                .income(createUserRequest.getIncome())
                .monthlyBudget(createUserRequest.getMonthlyBudget())
                .timezone(createUserRequest.getTimezone())
                .build();
    }
}
