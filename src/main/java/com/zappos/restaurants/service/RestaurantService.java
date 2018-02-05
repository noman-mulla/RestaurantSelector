package com.zappos.restaurants.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappos.restaurants.dao.RestaurantDao;
import com.zappos.restaurants.model.Restaurant;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	public List<Restaurant> getRestaurants(){
		return restaurantDao.getAllRestaurants();
	}

}
