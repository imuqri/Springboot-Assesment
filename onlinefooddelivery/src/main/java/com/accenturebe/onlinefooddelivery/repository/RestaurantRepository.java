package com.accenturebe.onlinefooddelivery.repository;

import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByName(String name);

}
