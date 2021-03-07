package com.example.ThreeLevelPassAuthSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@EnableAutoConfiguration

public class UserController {

 @Autowired 
 UserService userservice;

	@RequestMapping("/")
  public ModelAndView home() {
		
		 return new org.springframework.web.servlet.ModelAndView("welcome", "loginUserData", new User());
		
	}
	
	@RequestMapping("/tryagain")
	  public ModelAndView tryagainhome() {
			
			 return new org.springframework.web.servlet.ModelAndView("welcome", "loginUserData", new User());
			
		}
	
	  @RequestMapping(value = "/addNewUser") 
	  public org.springframework.web.servlet.ModelAndView show() { 
		  return new org.springframework.web.servlet.ModelAndView("register", "user", new User());
	  }
	  
	  
	  @RequestMapping(value = "/addUser", method = RequestMethod.POST) public
	  ModelAndView addProcessRequest(@Valid @ModelAttribute("user") User user, BindingResult
	  bindingResult,ModelMap model) { 
		user.setTpass("Myimage");
		   userservice.insertUser(user);
	 
	  
	  model.addAttribute("message", "Sucessfully saved your data! Please try to login !!"); 
	    return new org.springframework.web.servlet.ModelAndView("welcome", "loginUserData", new User()); 
	  
	  }
	  
	  
	  @RequestMapping(value = "/login", method = RequestMethod.POST) public
	  String loginProcessRequest(@Valid @ModelAttribute("loginUserData") User user, BindingResult
	  bindingResult,ModelMap model) { 
		  
		  String logname=user.getUserName();
		  user.setTpass("Myimage");
		 Boolean check= userservice.getAllUser(user);
	 if(check)
	 {	
	  model.addAttribute("loggedname",logname);
	  return "logged"; 
	 }
	 else {
		 model.addAttribute("Errormsg","incorrect credentials");
		  return "errormsg"; 
	 }
	  }
	 
	  @RequestMapping(value = "/Logout", method = RequestMethod.GET) public
	  String logoutProcessRequest(HttpServletRequest request,ModelMap model) { 
		  
		  HttpSession session=request.getSession();  
          session.invalidate();
	  
	  model.addAttribute("loggedoutmessage",
	  "Sucessfully logged out !");
	  return "logout"; 
	  
	  }

}
