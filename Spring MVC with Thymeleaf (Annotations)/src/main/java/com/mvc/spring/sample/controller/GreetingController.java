package com.mvc.spring.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Aykut on 30.01.2016.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(
    		@RequestParam(value="name", required=false, defaultValue="World") String name, 
    		@RequestParam(value="age", required=false, defaultValue="0") int age, 
    		Model model) {
    	
    	name = name + " (comes from url)" + age;
    	
        model.addAttribute("person", name);
        return "basic/greeting";
    }
    
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model) {
  
    	List<User> users = new ArrayList<>();
    	users.add(new User("ahmet", 21));
    	users.add(new User("ayse", 22));
    	users.add(new User("ebru", 33));
    	
    	model.addAttribute("userList", users);
    	
        return "list";
    }

}