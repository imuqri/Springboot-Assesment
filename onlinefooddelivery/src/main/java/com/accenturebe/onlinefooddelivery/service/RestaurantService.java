package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import com.accenturebe.onlinefooddelivery.exception.RestaurantAlreadyExistsException;
import com.accenturebe.onlinefooddelivery.exception.RestaurantNotFoundException;
import com.accenturebe.onlinefooddelivery.mapper.RestaurantMapper;
import com.accenturebe.onlinefooddelivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        boolean exists = restaurantRepository.existsByName(restaurantDTO.getName());
        if (exists) {
            throw new RestaurantAlreadyExistsException("Restaurant with name '" + restaurantDTO.getName() + "' already exists");
        }

        Restaurant restaurant = restaurantMapper.toEntity(restaurantDTO);
        Restaurant saved = restaurantRepository.save(restaurant);
        return restaurantMapper.toDTO(saved);
    }

    public Restaurant
