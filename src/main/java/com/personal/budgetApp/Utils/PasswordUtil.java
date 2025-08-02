package com.personal.budgetApp.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String userPassword) {
        return encoder.encode(userPassword);
    }

    public static boolean verifyPassword(String userPassword, String hashPassword) {
        return encoder.matches(userPassword, hashPassword);
    }

}
