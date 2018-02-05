package com.zappos.restaurants.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappos.restaurants.dao.MenuTypeDao;
import com.zappos.restaurants.model.MenuType;

@Service
@Transactional
public class MenuTypeService {
	
	@Autowired
	private MenuTypeDao menuTypeDao;
	
	public List<MenuType> getMenuTypes(){
		return menuTypeDao.getAllMenuType();
	}

}
