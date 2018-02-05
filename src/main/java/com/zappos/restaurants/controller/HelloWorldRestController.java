package com.zappos.restaurants.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class HelloWorldRestController {
	
	
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreetingHello(){
		String availableEndpoints = "Welcome to Restaurant Selector - Available Endpoints \n"+
									"1. /getRestaurants - Returns all available restuarants \n"+
									"2. /getMenuTypes - Returns all available menu types \n";
		
		return availableEndpoints; 
		
		
	}
	@RequestMapping(value="/greetings/{name}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreeting(@PathVariable String name){
		return "Hello "+name; 
		
		
	}
	
	
	
	
	
	

}
