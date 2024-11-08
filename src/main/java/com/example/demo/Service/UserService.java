package com.example.demo.Service;


import java.util.Optional;

import com.example.demo.Entity.User;

public interface UserService {
	
	 User createUser(User u);
	 
     Optional<User> findbynameandpassword(String name,String password);

}
