package com.personal.budgetApp.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestValidationFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(RequestValidationFilter.class);

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    logger.info("Incoming request to URI: {}", httpRequest.getRequestURI());

    String authHeader = httpRequest.getHeader("Authorization");
    String contentType = httpRequest.getHeader("Content-Type");

    // ✅ Authorization check
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      httpResponse.sendError(
          HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
      return;
    }

    // ✅ Content-Type check
    if (contentType == null || !contentType.equalsIgnoreCase("application/json")) {
      httpResponse.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid Content-Type");
      return;
    }

    // ✅ Proceed with next filter/controller
    chain.doFilter(request, response);
  }
}
