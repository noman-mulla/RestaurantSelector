package com.zappos.restaurants.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Column(name="rname")
	private String name;
	
	@Column(name="restaurant_id", unique = true, nullable = false)
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="address")
	private String address;
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "restaurant")
	@JsonManagedReference
	private Set<MenuType> menuTypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public Set<MenuType> getMenuTypes() {
		return menuTypes;
	}

	public void setMenuTypes(Set<MenuType> menuTypes) {
		this.menuTypes = menuTypes;
	}
	
	

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", id=" + id + ", rating=" + rating
				+ ", address=" + address + "]";
	}

	
	
	

}
