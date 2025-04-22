package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.MenuDTO;
import com.accenturebe.onlinefooddelivery.entity.Menu;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface MenuMapper {
    Menu toMenu (MenuDTO menuDTO);
    MenuDTO toMenuDTO (Menu menu);
}
