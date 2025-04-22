package com.accenturebe.onlinefooddelivery.controller;

import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import com.accenturebe.onlinefooddelivery.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    // Constructor injection
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantService.addRestaurant(restaurantDTO);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody @Valid RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantService.updateRestaurant(id, restaurantDTO);
        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
