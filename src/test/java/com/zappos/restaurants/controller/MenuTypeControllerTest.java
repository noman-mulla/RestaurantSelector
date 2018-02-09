package com.zappos.restaurants.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zappos.restaurants.model.MenuType;
import com.zappos.restaurants.model.Restaurant;
import com.zappos.restaurants.service.MenuTypeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@WebAppConfiguration
public class MenuTypeControllerTest {
	
	
private MockMvc mockMvc;
	
	
	
	@Mock
	MenuTypeService menuTypeService ;
	@InjectMocks
	MenuTypeController menuTypeController;

	@Autowired
    private WebApplicationContext webApplicationContext;
	
	
	
	 public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
             MediaType.APPLICATION_JSON.getSubtype(),                        
             Charset.forName("utf8")                     
             );
	
	 @Before
	 public void setup() {
		
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(menuTypeController).build();

	}
	
	
	@Test
    public void findMenuTypeRestaurantById() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("abc");
        restaurant.setAddress("730 south may");
        restaurant.setRating(5);
        
        MenuType menuType = new MenuType();
        menuType.setType("breakfast");
        Set<MenuType> menuTypeSet = new HashSet<MenuType>();
        menuTypeSet.add(menuType);
        restaurant.setMenuTypes(menuTypeSet);
        menuType.setRestaurant(restaurant);
        
 
        Mockito.when(menuTypeService.getMenuTypesByRestaurantId(0)).thenReturn(Arrays.asList(menuType));
        
 
        mockMvc.perform(get("/getMenuTypeByRestaurantId/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type", is("breakfast")));
 
        verify(menuTypeService, times(1)).getMenuTypesByRestaurantId(0);
        verifyNoMoreInteractions(menuTypeService);
    }

	
	

}
