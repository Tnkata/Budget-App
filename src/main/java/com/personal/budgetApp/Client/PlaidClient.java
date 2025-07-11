package com.personal.budgetApp.Client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.personal.budgetApp.Config.webClientConfig;

@Component
public class PlaidClient {

    private final WebClient webClient = webClientConfig.webClient();


}
