package com.personal.budgetApp.Repository;

import com.personal.budgetApp.DBEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if a User with the given accountId exists
    boolean existsByAccountId(String accountId);

    // You can add other query methods as needed, e.g.,
    User findByAccountId(String accountId);

    Optional<User> findByEmail(String email);
}
