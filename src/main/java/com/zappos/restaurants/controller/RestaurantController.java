package com.zappos.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}