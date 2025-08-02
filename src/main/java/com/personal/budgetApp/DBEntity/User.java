package com.personal.budgetApp.DBEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACCOUNT_ID", nullable = false, unique = true)
    private String accountId;

    private String firstName;

    private String lastName;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String currency;

    private BigDecimal income;

    private BigDecimal monthlyBudget;

    private String timezone;

    private LocalDate createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDate.now();
    }
}
