package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant toRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
}

