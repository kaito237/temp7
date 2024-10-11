package com.example.restaurant.menu;
import com.example.restaurant.menu.dto.MenuUpdateDto;
import com.example.restaurant.restaurant.entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository; // Khai báo MenuRepository
    public void updateMenuList(RestaurantEntity findRestaurant, List<MenuUpdateDto> menuUpdateDtoList) {
        List<MenuEntity> menuList = findRestaurant.getMenuList();
        for (MenuEntity menu : menuList) {
            menuRepository.delete(menu);
        }
    }

}

