package com.personal.budgetApp.Model;

import static com.personal.budgetApp.Constants.ErrorMessageConstants.ERROR_CODE;
import static com.personal.budgetApp.Constants.ErrorMessageConstants.ERROR_MESSAGE;
import static com.personal.budgetApp.Constants.ErrorMessageConstants.ERROR_DETAIL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;




@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    @JsonProperty(ERROR_CODE)
    private String errorCode;

    @JsonProperty(ERROR_MESSAGE)
    private String errorMessage;

    @JsonProperty(ERROR_DETAIL)
    private String errorDetail;

}
