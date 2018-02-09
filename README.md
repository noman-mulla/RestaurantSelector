## Available endpoints ##

1. /getRestaurants - returns all restaurants from database

            Output :
               [
                   {"name":"ML","id":2,"rating":4,"address":"730 South May Street",
                   "menuTypes":[
                   {"id":0,"type":"breakfast",
                   "menuItem":[
                   {"id":1,"itemName":"coffee"}
                   ]}]},
                   {"name":"ML Kitchen","id":3,"rating":5,"address":"730 South May Street",
                   "menuTypes":[]}
                 ]
     
2. /getRestaurant/{id} - returns single restaurant data having {id}

            input: {id} - 2

            output:
              {
                "name":"ML","id":2,"rating":4,"address":"730 South May Street",
                "menuTypes":[
                 {"id":0,"type":"breakfast",
                 "menuItem":[
                  {"id":1,"itemName":"coffee"}]}]
               }
   
3. /addRestaurant - Inserts the Restaurant in Database

4. /removeRestaurant/{id} - Removes the Restaurant with {id}

5. /getMenuTypeByRestaurantId/{restId} - Returns Menu Types and Menu Items for Restaurant having {restId}

6. /addMenuTypeForRestaurant - Adds Menu Types and Menu Items to a Restaurant.


## Technology Stack Used ##

 - Spring MVC, Hibernate.
 - JUnit, Mockito - for testing.
 - MySQL - Database.
 - IBM Bluemix - IBM's Cloud Platform.
 - Maven - Build Tool
 
 
## How to Run the Application? ##
 
 1. Clone the repo https://github.com/noman-mulla/RestaurantSelector.git
 
 2. Edit database.properties to connect to your database.
    or
    Create a new database and import mnomaan_restaurant_selector.sql
 3. Run Command -> mvn clean install (Make Sure maven is installed)
 4. Deploy the war file on Tomcat to run the application.
 
 
Current working version can be accessed via link -> https://restaurantselector.mybluemix.net/  (Deployed on IBM's Bluemix Cloud)
(If browser shows Error Code 500, just refresh the browser)


## Future Work ##
1. Add Redis Caching Layer
2. Add auth0 using Spring Security.
 
 
 
 
