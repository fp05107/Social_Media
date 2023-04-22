package com.socialmedia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
