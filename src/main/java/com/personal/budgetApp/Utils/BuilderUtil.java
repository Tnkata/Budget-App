package com.personal.budgetApp.Utils;

import com.personal.budgetApp.DBEntity.User;
import com.personal.budgetApp.Request.User.CreateUserRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BuilderUtil {

    public static User buildDBDetails(CreateUserRequest createUserRequest) {
        String hashedPassword = PasswordUtil.hashPassword(createUserRequest.getPassword());

        return User.builder()
                .accountId(ValidationUtil.generateAccountId())
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(hashedPassword)
                .dateOfBirth(createUserRequest.getDateOfBirth())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .currency(createUserRequest.getCurrency())
                .income(createUserRequest.getIncome())
                .monthlyBudget(createUserRequest.getMonthlyBudget())
                .timezone(createUserRequest.getTimezone())
                .build();
    }
}
