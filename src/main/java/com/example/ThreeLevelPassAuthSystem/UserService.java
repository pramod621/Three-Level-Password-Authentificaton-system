package com.example.ThreeLevelPassAuthSystem;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	 @Autowired
	    EmployeeRepository repository;
	public void insertUser(User udata) {
		// TODO Auto-generated method stub
		 System.out.println("inside service"+udata);
		 repository.save(udata);
	
			
	}
	public Boolean getAllUser(User user) {
		
		 List<User> userList = repository.findAll();
	        if(userList.size() > 0) {
	        	for (User u :userList)
	        	{
	      if (user.getUserName().equalsIgnoreCase(u.getUserName()) && user.getFpass().equalsIgnoreCase(u.getFpass())
	       && user.getSpass().equalsIgnoreCase(u.getSpass())&&user.getTpass().equalsIgnoreCase(u.getTpass())) {
	    	  return true; 
	               }
	        		
	        	}
	        	
	        } else {
	            return false;
	        }
	        
			return false;
		
		// TODO Auto-generated method stub
		
	}
}
