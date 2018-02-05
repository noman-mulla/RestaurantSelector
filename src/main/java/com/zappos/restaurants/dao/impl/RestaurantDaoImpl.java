package com.zappos.restaurants.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zappos.restaurants.dao.RestaurantDao;
import com.zappos.restaurants.model.Restaurant;

@Repository
public class RestaurantDaoImpl implements RestaurantDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		        return sessionFactory.getCurrentSession();
		    }


	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAllRestaurants() {
		return getCurrentSession().createQuery("from Restaurant").list();
	}


	@Override
	public Restaurant getRestaurantById(int id) {
		return (Restaurant) getCurrentSession().get(Restaurant.class, id);
	}


	@Override
	public void deleteRestaurantById(int id) {
		Restaurant restaurant = (Restaurant) getCurrentSession().load(Restaurant.class, id);
		getCurrentSession().delete(restaurant);		
	}

}
