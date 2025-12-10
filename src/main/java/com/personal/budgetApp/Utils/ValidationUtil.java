package com.personal.budgetApp.Utils;

import java.util.UUID;

public class ValidationUtil {

  public static String generateAccountId() {
    return UUID.randomUUID().toString();
  }
}
