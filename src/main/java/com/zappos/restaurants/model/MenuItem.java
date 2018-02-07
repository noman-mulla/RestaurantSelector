package com.zappos.restaurants.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="menuitem")
public class MenuItem {
	
	@Column(name="menu_item_id")
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="menuItem")
	@JsonBackReference
	private Set<MenuType> menuType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Set<MenuType> getMenuType() {
		return menuType;
	}

	public void setMenuType(Set<MenuType> menuType) {
		this.menuType = menuType;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", menuType="
				+ menuType + "]";
	}
	
	
	
	

}
