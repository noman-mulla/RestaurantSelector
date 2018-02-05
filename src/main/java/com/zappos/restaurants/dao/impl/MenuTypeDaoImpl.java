package com.zappos.restaurants.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zappos.restaurants.dao.MenuTypeDao;
import com.zappos.restaurants.model.MenuType;

@Repository
public class MenuTypeDaoImpl implements MenuTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		        return sessionFactory.getCurrentSession();
		    }

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuType> getAllMenuType() {
		return getCurrentSession().createQuery("from MenuType").list();

	}

}
