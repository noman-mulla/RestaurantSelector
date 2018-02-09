package com.zappos.restaurants.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="menu_menuitem",
			joinColumns={@JoinColumn(name="menu_id",nullable=false,updatable=false)},
			inverseJoinColumns={ @JoinColumn(name="menu_item_id",nullable=false,updatable=false)}
			)
	@JsonManagedReference
	private Set<MenuItem> menuItem;

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
	
	

	public Set<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Set<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}
	
	

	@Override
	public String toString() {
		return "MenuType [id=" + id + ", type=" + type + "]";
	}
	
	
	
	
}
