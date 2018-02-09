package com.zappos.restaurants.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.zappos.restaurants.dao.RestaurantDao;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.RestaurantService;
import com.zappos.restaurants.service.impl.RestaurantServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@WebAppConfiguration
public class RestaurantControllerTest {
	
	private MockMvc mockMvc;
	
	
	
	@Mock
	RestaurantService restaurantService ;
	@InjectMocks
	RestaurantController restaurantController;

	@Autowired
    private WebApplicationContext webApplicationContext;
	
	
	
	 public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
             MediaType.APPLICATION_JSON.getSubtype(),                        
             Charset.forName("utf8")                     
             );
	
	 @Before
	 public void setup() {
		
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();

	}
	
	
	@Test
    public void findRestaurantById() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("abc");
        restaurant.setAddress("730 south may");
        restaurant.setRating(5);
 
        Mockito.when(restaurantService.getRestaurantById(0)).thenReturn(restaurant);
        
 
        mockMvc.perform(get("/getRestaurant/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("abc")))
                .andExpect(jsonPath("$.address", is("730 south may")))
                .andExpect(jsonPath("$.rating", is(5)));
 
        verify(restaurantService, times(1)).getRestaurantById(0);
        verifyNoMoreInteractions(restaurantService);
    }
	
	
	@Test
    public void findAllRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("abc");
        restaurant.setAddress("730 south may");
        restaurant.setRating(5);
 
        Mockito.when(restaurantService.getRestaurants()).thenReturn(Arrays.asList(restaurant));
        
 
        mockMvc.perform(get("/getRestaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("abc")))
                .andExpect(jsonPath("$[0].address", is("730 south may")))
                .andExpect(jsonPath("$[0].rating", is(5)));
 
        verify(restaurantService, times(1)).getRestaurants();
        verifyNoMoreInteractions(restaurantService);
    }
	
	
	
	
	
	
	
	
	

}
