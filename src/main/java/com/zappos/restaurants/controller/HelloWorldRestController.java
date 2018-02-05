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
									"2. /getRestaurant/{id} - Returns a single restaurant having {id} \n"+
									"3. /addRestaurant - Adds a Single Restaurant to database \n"+
									"4. /removeRestaurant/{id} - Removes Restaurant having {id} \n"+
									"5. /getMenuTypes - Returns all available menu types \n";
		
		return availableEndpoints; 
		
		
	}
	@RequestMapping(value="/greetings/{name}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreeting(@PathVariable String name){
		return "Hello "+name; 
		
		
	}
	
	
	
	
	
	

}
