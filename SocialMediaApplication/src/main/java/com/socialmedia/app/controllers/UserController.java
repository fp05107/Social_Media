package com.socialmedia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.entities.User;
import com.socialmedia.app.exception.UserException;
import com.socialmedia.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		
		User registeredUser = userService.registerNewUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
