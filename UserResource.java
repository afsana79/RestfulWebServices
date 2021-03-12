package com.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserResource {
//retrieveAllUsers
//GET users	
	@Autowired
	UserDaoService service = new  UserDaoService();
	
//retrieve user(int id)	
//GET user(int id)	
	@GetMapping("/users")
	public List<User> retrieveAllUsers (){
		 return service.findAllUsers();		
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser (@PathVariable int id){
		 return service.findOne(id);		
	}
	
	//create new user
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		System.out.println("in post method  "+user);
		User savedUser = service.save(user);
		System.out.println("after saving  "+user);
	}
	

}
