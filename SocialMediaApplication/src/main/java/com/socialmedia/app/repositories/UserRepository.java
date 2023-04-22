package com.socialmedia.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	List<User> findByInterestsContainingIgnoreCase(String interest);
	
}
