package com.example.restaurant.menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    void delete(MenuEntity menu);
}
