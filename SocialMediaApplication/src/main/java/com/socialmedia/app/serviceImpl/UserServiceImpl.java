package com.socialmedia.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.Post;
import com.socialmedia.app.entities.User;
import com.socialmedia.app.exception.UserException;
import com.socialmedia.app.repositories.UserRepository;
import com.socialmedia.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * @param User user
	 * @exception UserException
	 * This Method Register a new user
	 */
	public User registerNewUser(User user) throws UserException {
		return userRepository.save(user);
	}

	/****
	 * 
	 * 
	 */
	@Override
	public User editUserProfile(Integer id, User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUserByUserName(String userName) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUserByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUserByInterests(String interests) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserById(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByUserId(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
