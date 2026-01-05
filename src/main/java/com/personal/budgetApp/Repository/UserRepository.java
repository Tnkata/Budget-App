package com.personal.budgetApp.Repository;

import com.personal.budgetApp.Model.DBEntity.UserDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

  Optional<UserDTO> checkIfAccountIdExists(String accountId);

  // Check if a User with the given accountId exists
  UserDTO getUserDetails(String accountId);

  Optional<UserDTO> findByEmail(String email);
}
