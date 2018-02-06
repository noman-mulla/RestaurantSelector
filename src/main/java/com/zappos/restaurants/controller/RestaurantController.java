package com.zappos.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.RestaurantService;


@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@RequestMapping(value="/getRestaurants",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants(); 
		
	}
	
	@RequestMapping(value="/getRestaurant/{id}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public Restaurant getRestaurantById(@PathVariable int id){
		return restaurantService.getRestaurantById(id);
		
	}
	
	@RequestMapping(value="/removeRestaurant/{id}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public void removeRestauranttById(@PathVariable int id){
		 restaurantService.deleteRestaurantById(id);
		
	}
	
	@RequestMapping(value="/addRestaurant",method=RequestMethod.POST,headers="Accept=application/json",produces="application/json")
	public void addRestaurant(@RequestBody Restaurant restaurant){
		
		restaurantService.addRestaurant(restaurant);
		
	}
	
	
	
	

}
