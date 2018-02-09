package com.zappos.restaurants.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappos.restaurants.dao.MenuTypeDao;
import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.MenuTypeService;
import com.zappos.restaurants.service.RestaurantService;

@Service
@Transactional
public class MenuTypeServiceImpl implements MenuTypeService{
	
	@Autowired
	private MenuTypeDao menuTypeDao;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Override
	public List<MenuType> getMenuTypesByRestaurantId(int restId){
		return menuTypeDao.getMenuTypesByRestaurantId(restId);
	}

	@Override
	public void addMenuTypeForRestaurant(int restId, MenuType menuType) {
		Restaurant restaurant = restaurantService.getRestaurantById(restId);
		
		if(restaurant != null){
			restaurant.getMenuTypes().add(menuType);
			
			
			restaurantService.addMenuTypeForRestaurant(restaurant);
		}		
	}

}
