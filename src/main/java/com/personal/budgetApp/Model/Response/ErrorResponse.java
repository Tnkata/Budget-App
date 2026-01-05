package com.personal.budgetApp.Model.Response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {

  private String code;

  private String description;

  private List<Object> detail;
}
