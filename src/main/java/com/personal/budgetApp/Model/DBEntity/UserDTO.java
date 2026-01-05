package com.personal.budgetApp.Model.DBEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ACCOUNT_ID", nullable = false, unique = true)
  private String accountId;

  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @Column(name = "USERNAME", nullable = false)
  private String username;

  @Column(name = "EMAIL", nullable = false, unique = true)
  private String email;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Column(name = "DATE_OF_BIRTH")
  private String dateOfBirth;

  @Column(name = "CURRENCY")
  private String currency;

  @Column(name = "INCOME")
  private BigDecimal income;

  @Column(name = "MONTHLY_BUDGET")
  private BigDecimal monthlyBudget;

  @Column(name = "TIMEZONE")
  private String timezone;

  @Column(name = "CREATED_AT")
  private LocalDate createdAt;

  @Column(name = "BALANCE")
  private String balance;

  @PrePersist
  void onCreate() {
    this.createdAt = LocalDate.now();
  }
}
