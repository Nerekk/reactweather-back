package org.example.reactweatherback.ApiRepos;

import java.util.Optional;

import org.example.reactweatherback.ApiEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
