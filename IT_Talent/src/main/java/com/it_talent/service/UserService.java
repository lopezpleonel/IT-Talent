package com.it_talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it_talent.dao.UserRepository;
import com.it_talent.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) this.userRepository.findAll();
	}

	public User saveUser(User user) {
		userRepository.save(user);
		user.setToken(user.getId().toString());
		return this.userRepository.save(user);
	}	

}
