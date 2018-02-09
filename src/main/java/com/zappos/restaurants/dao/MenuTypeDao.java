package com.zappos.restaurants.dao;

import java.util.List;

import com.zappos.restaurants.model.MenuType;

public interface MenuTypeDao {
	
	List<MenuType> getMenuTypesByRestaurantId(int restId);

}
