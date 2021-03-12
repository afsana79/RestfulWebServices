package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List <User> users = new ArrayList<>();
	
	static {
		users.add( new User(1,"adam",new Date()));
		users.add( new User(2,"bella",new Date()));
		users.add( new User(3,"carly",new Date()));		
	}
	private static int usersCount=3;
	
	//findAll
	public List<User> findAllUsers() {
		return users;		
	}
	//findOne
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	//save
	public User save(User user) {
		if(user.getId() == null) {
			System.out.println("in save method");
			user.setId( ++usersCount );
		}
			users.add(user);
System.out.println("after save in list  "+users.get(usersCount));

			return user;			
	}
}
