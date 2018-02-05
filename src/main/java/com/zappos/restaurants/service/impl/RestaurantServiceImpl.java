package com.zappos.restaurants.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappos.restaurants.dao.RestaurantDao;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public List<Restaurant> getRestaurants(){
		return restaurantDao.getAllRestaurants();
	}

}
