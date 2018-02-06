package com.zappos.restaurants.service;

import java.util.List;

import com.zappos.restaurants.model.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> getRestaurants();
	public Restaurant getRestaurantById(int id);
	public void deleteRestaurantById(int id);
	public void addRestaurant(Restaurant restaurant);
	
	

}
