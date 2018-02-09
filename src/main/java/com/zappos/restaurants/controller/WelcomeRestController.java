package com.zappos.restaurants.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class WelcomeRestController {
	
	
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET,headers="Accept=application/json",produces="application/json")
	public String getGreetingHello(){
		String availableEndpoints = "Welcome to Restaurant Selector - Available Endpoints \n"+
									"1. /getRestaurants - Returns all available restuarants \n"+
									"2. /getRestaurant/{id} - Returns a single restaurant having {id} \n"+
									"3. /addRestaurant - Adds a Single Restaurant to database \n"+
									"4. /removeRestaurant/{id} - Removes Restaurant having {id} \n"+
									"5. /getMenuTypeByRestaurantId/{restId} - Returns all available menu types for restaurant \n"+
									"6. /addMenuTypeForRestaurant - Add a menu type with 0 menu item \n"+
									"7. /deleteMenuTypeForRestaurant/{restId} - Deletes a menu type for a restaurant \n"+
									"8. /addMenuItemForMenu/{menuId} -Add a menu Item for a specific menu type \n"+
									"9. /getMenuItemsForMenu/{menuId} - Returns all Menu Item for a Menu Type \n"+
									"10. /deleteMenuItemForMenu/{menuId}- Deletes a Menu Item\n";
		
		return availableEndpoints; 
		
		
	}

}
