package com.socialmedia.app.serviceImpl;

import java.util.List;
import java.util.Optional;

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
		Optional<User> registeredUser = userRepository.findById(user.getId());
		
		if(registeredUser.isPresent()) {
			throw new UserException("User already Exists With This Credential");
		}
		
		return userRepository.save(user);
	}
	
	

	/****
	 * @param Integer id, User user
	 * @exception User Exception
	 * This Method Is To Update The User Profile
	 */
	@Override
	public User editUserProfile(Integer id, User user) throws UserException {
		
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent()) {
			User updatedUser = opt.get();
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setPassword(user.getUsername());
			updatedUser.setBio(user.getBio());
			updatedUser.setPhoneNo(user.getPhoneNo());
			return userRepository.save(updatedUser);
		}
		else {
			throw new UserException("User Not Found With The Id");
		}
		
		
	}

	
	/**
	 * @param String userName
	 * @return User
	 *  This method can be used to search a user by his/her user name
	 */
	@Override
	public User searchUserByUserName(String userName) throws UserException {
		
		Optional<User> opt = userRepository.findByUsername(userName);
		if(opt.isEmpty()) {
			throw new UserException("User Not Found With this UserName"+userName);
		}else {
			return opt.get();
		}
	}

	/**
	 * @param String email
	 * @return User
	 * This method can be use to search a user by username
	 */
	@Override
	public User searchUserByEmail(String email) throws UserException {
		
		Optional<User> opt = userRepository.findByEmail(email);
		if(opt.isEmpty()) {
			throw new UserException("User Not Found With this Email"+email);
		}else {
			return opt.get();
		}
	}

	
	/**
	 * 
	 * @param String interests
	 * @return User
	 * With this method we can find user by their intersts
	 */
	@Override
	public List<User> searchUserByInterests(String interests) throws UserException {
		
		List<User> list = userRepository.findByInterestsContainingIgnoreCase(interests);
		if(list.size() > 0)return list;
		else throw new UserException("No User Found With these Intersts");
	}

//	=============================================================================
	
	/**
	 * @param Integer id
	 * @return User
	 * With this method a user can delete his/her account permanently by giving id
	 */
	@Override
	public User deleteUserById(Integer id) throws UserException {
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent()) {
			User deletedUser = opt.get();
			userRepository.delete(deletedUser);
			return deletedUser;
		}else {
			throw new UserException("User Not Found With This Id"+id);
		}
	}

	
	/**
	 * @param String email
	 * @return User
	 * With this method a user can delete his/her account permanently by giving email
	 */
	@Override
	public User deleteUserByEmail(String email) throws UserException {
		Optional<User> opt = userRepository.findByEmail(email);
		if(opt.isPresent()) {
			User deletedUser = opt.get();
			userRepository.delete(deletedUser);
			return deletedUser;
		}else {
			throw new UserException("User Not Found With This Email"+email);
		}
	}

	
}
