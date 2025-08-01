# 💸 Budget App — Backend Component

A simple **budget tracking API** built with **Spring Boot**.  
This app lets you manage users, budgets, and transactions — with **scheduled jobs**, **external API integration** (Plaid), and a **custom filter** for request validation and CORS handling.

---

## 📌 Features

✅ RESTful CRUD endpoints for **Users**, **Budgets**, **Transactions**  
✅ **Custom Filter** for:
- Validating `Content-Type` and `Authorization` headers
- Adding **CORS** headers for cross-origin requests  
  ✅ **Scheduler** for automatic jobs (e.g., generate daily/monthly reports)  
  ✅ Example **Plaid Client** to fetch financial data from external APIs  
  ✅ Layered project structure with **Controller**, **Service**, **Repository**, **Client**, **Scheduler**, and **Filter**

---

## 🗂️ Project Structure

---

## ⚙️ Tech Stack

- **Java 17+**
- **Spring Boot**
    - Spring Web MVC
    - Spring Data JPA
    - Spring WebFlux (`WebClient` for Plaid API)
    - Spring Scheduler
- **H2** (in-memory dev DB)
- Optional: PostgreSQL/MySQL in production

---

## 🚦 How It Works

### ✅ 1. **REST API**
- `UserController` — create, read, update users
- `BudgetController` — manage budgets
- `TransactionController` — manage expenses & income

### ✅ 2. **Custom Filter**
- Checks `Content-Type` is `application/json`
- Checks `Authorization` starts with `Bearer `
- Adds **CORS headers** (`Access-Control-Allow-Origin`, etc.)
- Handles preflight `OPTIONS` requests

### ✅ 3. **Scheduler**
- Runs **automatic jobs** (e.g., daily or monthly report generation)
- Example: `ReportScheduler` runs every minute to simulate report creation

### ✅ 4. **Plaid Client**
- Example `PlaidClient` uses `WebClient` to call Plaid’s sandbox API
- Wraps auth headers, request body, and JSON parsing

---

## 🏃‍♂️ Running Locally

1️⃣ **Clone the repo**
```bash
git clone https://github.com/YOUR_USERNAME/budgetapp.git
cd budgetapp

```

2️⃣ Configure Plaid (optional)
Add your Plaid sandbox keys to src/main/resources/application.properties:
```bash
plaid.client_id=YOUR_PLAID_CLIENT_ID
plaid.secret=YOUR_PLAID_SECRET
plaid.base_url=https://sandbox.plaid.com
```
3️⃣ Run the app

```bash
Copy
Edit
./mvnw spring-boot:run
or
```
```bash
mvn spring-boot:run
```
4️⃣ Visit http://localhost:8080
