package com.socialmedia.app.service;

import java.util.List;

import com.socialmedia.app.entities.Post;
import com.socialmedia.app.entities.User;
import com.socialmedia.app.exception.UserException;

public interface UserService {
	
	public User registerNewUser(User user) throws UserException;
	
	public User editUserProfile(Integer id, User user) throws UserException;
	
	public User searchUserByUserName(String userName) throws UserException;
	
	public User searchUserByEmail(String email) throws UserException;
	
	public List<User> searchUserByInterests(String interests) throws UserException;
	
	public User deleteUserById(Integer id) throws UserException;
	
	public User deleteUserByEmail(String email) throws UserException;
	
	
	
	
}
