package com.zappos.restaurants.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappos.restaurants.dao.MenuTypeDao;
import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.service.MenuTypeService;

@Service
@Transactional
public class MenuTypeServiceImpl implements MenuTypeService{
	
	@Autowired
	private MenuTypeDao menuTypeDao;
	
	@Override
	public List<MenuType> getMenuTypes(){
		return menuTypeDao.getAllMenuType();
	}

}
