package com.example.restaurant.menu;

import com.example.restaurant.BaseEntity;
import com.example.restaurant.restaurant.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuEntity extends BaseEntity {
    private String nameFood;
    private int price;
    private String image;
    @Setter
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    public enum Status {
        AVAILABLE,
        OUT_OF_STOCK
    }
    public void setRestaurant(RestaurantEntity restaurant) {
        // Gán nhà hàng cho Menu
        this.restaurant = restaurant;

        // Kiểm tra xem nhà hàng có null không
        if (restaurant != null) {
            // Lấy danh sách menu và kiểm tra xem nó đã được khởi tạo chưa
            if (restaurant.getMenuList() == null) {
                restaurant.setMenuList(new ArrayList<>()); // Khởi tạo danh sách nếu chưa có
            }

            // Thêm menu hiện tại vào danh sách của nhà hàng
            restaurant.getMenuList().add(this);
        }
    }


}