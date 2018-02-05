package com.zappos.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurants.dao.RestaurantDao;
import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.MenuTypeService;
import com.zappos.restaurants.service.RestaurantService;


@RestController
public class HelloWorldRestController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private MenuTypeService menuTypeService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreetingHello(){
		return "Hello World"; 
		
		
	}
	@RequestMapping(value="/greetings/{name}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreeting(@PathVariable String name){
		return "Hello "+name; 
		
		
	}
	
	@RequestMapping(value="/getRestaurants",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants(); 
		
	}
	
	@RequestMapping(value="/getMenuTypes",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public List<MenuType> getMenuTypes(){
		return menuTypeService.getMenuTypes();
		
	}
	
	

}
