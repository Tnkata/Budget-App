# Budgeting Application API

A scalable backend API for a personal budgeting and financial management application built with Java and Spring Boot.

The platform allows users to:
- Manage accounts and wallets
- Track expenses and income
- Create budgets
- Monitor spending analytics
- Manage financial goals
- Receive notifications and alerts

---

# Features

## Authentication & Authorization
- JWT Authentication
- Role-based authorization
- Refresh tokens
- Password reset support

## User Management
- Create/update user profiles
- Manage account settings

## Account Management
- Checking accounts
- Savings accounts
- Credit card accounts
- Cash wallets

## Transaction Management
- Record income and expenses
- Categorize transactions
- Filter/search transactions
- Recurring transactions

## Budget Management
- Monthly budgets
- Category spending limits
- Budget utilization tracking

## Analytics
- Spending summaries
- Income vs expenses
- Monthly trends
- Category breakdowns

## Savings Goals
- Savings tracking
- Goal progress monitoring

---

# Tech Stack

## Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA

## Database
- PostgreSQL

## Documentation
- Swagger / OpenAPI

## Testing
- JUnit
- Mockito
- Testcontainers

## DevOps
- Docker
- GitHub Actions

---

# Project Structure

```text
src/main/java/com/budgetapp
│
├── auth
├── user
├── account
├── budget
├── transaction
├── category
├── analytics
├── goal
├── notification
│
├── config
├── security
├── exception
├── util
└── common