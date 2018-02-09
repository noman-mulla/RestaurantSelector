package com.zappos.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.MenuTypeService;
import com.zappos.restaurants.service.RestaurantService;

@RestController
public class MenuTypeController {
	
	@Autowired
	private MenuTypeService menuTypeService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@RequestMapping(value="/getMenuTypeByRestaurantId/{restId}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public List<MenuType> getMenuTypesByRestaurantId(@PathVariable int restId){
		return menuTypeService.getMenuTypesByRestaurantId(restId);
	}
	
	@RequestMapping(value="/addMenuTypeForRestaurant",method={RequestMethod.POST, RequestMethod.GET},headers="Accept=application/json",consumes="application/json",produces="application/json")
	public void addMenuTypeForRestaurant(@RequestBody MenuType menuType){	
		menuTypeService.addMenuTypeForRestaurant(2, menuType);	
	}
	
	
	
	

}
