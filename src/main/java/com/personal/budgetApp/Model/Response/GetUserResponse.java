package com.personal.budgetApp.Model.Response;

import static com.personal.budgetApp.Constants.ModelConstants.BALANCE;
import static com.personal.budgetApp.Constants.ModelConstants.EMAIL;
import static com.personal.budgetApp.Constants.ModelConstants.FIRST_NAME;
import static com.personal.budgetApp.Constants.ModelConstants.LAST_NAME;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

  @JsonProperty(LAST_NAME)
  private Long accountId;

  @JsonProperty(FIRST_NAME)
  private String firstName;

  @JsonProperty(LAST_NAME)
  private String lastName;

  @JsonProperty(BALANCE)
  private String balance;

  @JsonProperty(EMAIL)
  private String email;
}
