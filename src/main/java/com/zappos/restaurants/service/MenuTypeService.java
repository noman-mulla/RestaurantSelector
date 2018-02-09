package com.zappos.restaurants.service;

import java.util.List;

import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.model.Restaurant;

public interface MenuTypeService {
	
	public List<MenuType> getMenuTypesByRestaurantId(int restId);
	public void addMenuTypeForRestaurant(int restId,MenuType menuType);

}
