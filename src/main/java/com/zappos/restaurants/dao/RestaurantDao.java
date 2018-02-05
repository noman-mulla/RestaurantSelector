package com.zappos.restaurants.dao;

import java.util.List;

import com.zappos.restaurants.model.Restaurant;

public interface RestaurantDao {
	
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int id);
	void deleteRestaurantById(int id);

}
