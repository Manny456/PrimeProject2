package com.example.PrimeProject.Restaurantv1;


import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController

public class RestaurantController {


    private final RestaurantService restaurantService;

    @Autowired
    public  RestaurantController(final RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/api/v1/restaurants")
    public List<Restaurant> findAllRestaurants(){

        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/api/v1/restaurants/{id}")
    public Restaurant findSpecificRestaurant(@PathVariable("id") Long id){

        Restaurant restaurantById = this.restaurantService.getRestaurantById(id);
        return restaurantById;
    }

    @GetMapping("/api/v1/restaurantAverageScore/{id}")
    public Long GetAverageScores(@PathVariable("id") Long id) {
        return restaurantService.getsAverageScore(id);
    }

    @PostMapping("/api/v1/restaurants")
    public ResponseEntity<Restaurant> addingNewRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.createNewRestaurant(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/restaurants/{id}")
    public Restaurant editRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant restaurant){
        return this.restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/api/v1/restaurants/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id){
        this.restaurantService.deleteRestaurant(id);
    }
}
