package com.zappos.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.service.MenuTypeService;

@RestController
public class MenuTypeController {
	
	@Autowired
	private MenuTypeService menuTypeService;
	
	
	@RequestMapping(value="/getMenuTypes",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public List<MenuType> getMenuTypes(){
		return menuTypeService.getMenuTypes();
	}
	
	
	
	

}
