package com.zappos.restaurants.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="menutype")
public class MenuType {

	@Column(name="menu_id", unique = true, nullable = false)
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)		
	@JoinColumn(name = "restaurant_id", nullable = false)
	@JsonBackReference
	private Restaurant restaurant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "MenuType [id=" + id + ", type=" + type + "]";
	}
	
	
	
	
}
