package com.personal.budgetApp.Client;

import com.personal.budgetApp.Config.webClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PlaidClient {

  private final WebClient webClient = webClientConfig.webClient();
}
