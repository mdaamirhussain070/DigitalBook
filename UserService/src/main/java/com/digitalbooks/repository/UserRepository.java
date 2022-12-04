package com.digitalbooks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	User findByEmail(User user);

	Optional<User> findByUsername(String username);

	
}
