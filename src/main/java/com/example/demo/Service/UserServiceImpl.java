package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository urep;

	@Override
	public User createUser(User u) {
		
		return urep.save(u);
	}

	@Override
	public Optional<User> findbynameandpassword(String name, String password) {
		
		return urep.findByUsernameAndPassword(name, password);
	}
	
    
}
