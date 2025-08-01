package com.personal.budgetApp.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {

    private Long accountId;

    private String firstName;

    private String lastName;

    private String email;

    private String currency;
}
