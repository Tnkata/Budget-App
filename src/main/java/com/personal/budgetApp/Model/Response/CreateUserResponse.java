package com.personal.budgetApp.Model.Response;

import static com.personal.budgetApp.Constants.ModelConstants.ACCOUNT_ID;
import static com.personal.budgetApp.Constants.ModelConstants.BALANCE;
import static com.personal.budgetApp.Constants.ModelConstants.CURRENCY;
import static com.personal.budgetApp.Constants.ModelConstants.EMAIL;
import static com.personal.budgetApp.Constants.ModelConstants.FIRST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.LAST_NAME;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CreateUserResponse {

  @JsonProperty(ACCOUNT_ID)
  private Long accountId;

  @JsonProperty(FIRST_NAME)
  private String firstName;

  @JsonProperty(LAST_NAME)
  private String lastName;

  @JsonProperty(EMAIL)
  private String email;

  @JsonProperty(CURRENCY)
  private String currency;

  @JsonProperty(BALANCE)
  private String balance;
}
