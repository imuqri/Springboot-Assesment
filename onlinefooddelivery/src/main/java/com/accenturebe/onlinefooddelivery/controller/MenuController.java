package com.accenturebe.onlinefooddelivery.controller;

import com.accenturebe.onlinefooddelivery.dto.MenuDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.accenturebe.onlinefooddelivery.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    //Constructor Injection
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long menuId){
        MenuDTO getMenu = menuService.getMenuById(menuId);
        if (getMenu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 Not Found
        }
        return ResponseEntity.ok(getMenu);
    }

    @PostMapping("/create")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody @Valid MenuDTO menu){
        MenuDTO createdMenu = menuService.createMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);
    }

    @PutMapping("/update/{menuId}")
    public ResponseEntity<MenuDTO> updateMenu(@PathVariable Long menuId, @RequestBody MenuDTO menu){
        MenuDTO updatedMenu = menuService.updateMenu(menuId, menu);
        return ResponseEntity.ok(updatedMenu);
    }


    @DeleteMapping("/delete/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId){
        menuService.deleteMenu(menuId);
        return ResponseEntity.ok().build();
    }
}
