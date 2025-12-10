package com.personal.budgetApp.Config;

import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class webClientConfig {

  private static HttpClient httpClient() {
    return HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
  }

  @Bean
  public static WebClient webClient() {
    return WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient()))
        .build();
  }
}
