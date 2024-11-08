package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ResponsceStructure;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService ser;
	
	
	@PostMapping
	public ResponseEntity<ResponsceStructure<User>> createUser(@RequestBody User u)
	{
		User us = ser.createUser(u);
		
		ResponsceStructure<User> res = new ResponsceStructure<User>();
		res.setData(us);
		res.setMsg("user was created");
		res.setStatus(HttpStatus.CREATED.value());
       return new ResponseEntity<ResponsceStructure<User>>(res,HttpStatus.CREATED);		
	}
	
	@GetMapping("/{name}/{password}")
	public ResponseEntity<ResponsceStructure<User>> findbynameandpassowrd(@PathVariable String name,@PathVariable String password)
	{
		Optional<User> us = ser.findbynameandpassword(name, password);
		
		ResponsceStructure<User> res = new ResponsceStructure<User>();
	    if(us.isPresent())
	    {
	    	res.setData(us.get());
	    	res.setMsg("your username and password were correct");
	    	res.setStatus(HttpStatus.OK.value());
	    	return new ResponseEntity<ResponsceStructure<User>>(res,HttpStatus.OK);
	    }
	    else {
	    	res.setData(null);
	    	res.setMsg("your username and password were not correct");
	    	res.setStatus(HttpStatus.NOT_FOUND.value());
	    	return new ResponseEntity<ResponsceStructure<User>>(res,HttpStatus.NOT_FOUND);

	    }
	}
	
}
