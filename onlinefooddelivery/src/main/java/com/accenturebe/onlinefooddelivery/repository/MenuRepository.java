package com.accenturebe.onlinefooddelivery.repository;

import com.accenturebe.onlinefooddelivery.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
