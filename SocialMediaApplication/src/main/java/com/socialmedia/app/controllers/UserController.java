package com.socialmedia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws UserException
	 * With this API user can create new account
	 */
	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		
		User registeredUser = userService.registerNewUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.ACCEPTED);
		
	}
	
	/**
	 * 
	 * @param userId
	 * @param user
	 * @return
	 * With this API user can update their account details
	 */
	@PutMapping("/update/profile/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user){
		
		User updatedUser = userService.editUserProfile(userId, user);
		return new ResponseEntity<User>(updatedUser,HttpStatus.ACCEPTED);
		
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * With This API user can search users by their name
	 */
	@GetMapping("/{userName}")
	public ResponseEntity<User> findUserByUserName(@PathVariable String userName){
		
		User user = userService.searchUserByUserName(userName);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
//====================================================================
	/**\
	 * 
	 * @param email
	 * @return 
	 * With this API Admin can find user by email
	 */
	@GetMapping("/email/{email}")	
	public ResponseEntity<User> findUserByUserEmail(@PathVariable String email){
		
		User user = userService.searchUserByEmail(email);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	
	/**
	 * 
	 * @param interests
	 * @return
	 * With this API user can search users with interests
	 */
	@GetMapping("/interests/{interests}")
	public ResponseEntity<List<User>> findUsersByInterests(@PathVariable String interests){
		
		List<User> users = userService.searchUserByInterests(interests);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 * with this API user can delete his account
	 */
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<User> deleteUserById(@PathVariable Integer userId){
		
		User user = userService.deleteUserById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public ResponseEntity<User> deleteUserByEmail(@PathVariable String email){
		
		User user = userService.deleteUserByEmail(email);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
}
