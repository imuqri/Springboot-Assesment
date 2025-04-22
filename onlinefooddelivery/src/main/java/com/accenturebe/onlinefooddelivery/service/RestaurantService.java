package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.exception.RestaurantAlreadyExistsException;
import com.accenturebe.onlinefooddelivery.exception.RestaurantNotFoundException;
import com.accenturebe.onlinefooddelivery.mapper.RestaurantMapper;
import com.accenturebe.onlinefooddelivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    // Constructor injection
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public Restaurant addRestaurant(RestaurantDTO restaurantDTO) {
        boolean exists = restaurantRepository.existsByName(restaurantDTO.getName());

        if (exists) {
            throw new RestaurantAlreadyExistsException("Restaurant with name '" + restaurantDTO.getName() + "' already exists");
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
        restaurant.setEmail(restaurantDTO.getEmail());

        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + id + " not found"));
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + id + " not found"));

        existingRestaurant.setName(restaurantDTO.getName());
        existingRestaurant.setAddress(restaurantDTO.getAddress());
        existingRestaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
        existingRestaurant.setEmail(restaurantDTO.getEmail());

        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurant(Long id) {
        Restaurant existingRestaurant = getRestaurantById(id);
        restaurantRepository.delete(existingRestaurant);
    }
}
