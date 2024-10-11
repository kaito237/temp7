package com.example.restaurant.menu.dto;

import com.example.restaurant.menu.MenuEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuRegisterDto {
    @NotBlank(message = "")
    private String nameFood;

    @Range(min = 500, max = 1000000, message = "")
    private int price;
    private String image;
    private MenuEntity.Status status;

    public MenuEntity toMenuEntity() {
       return  MenuEntity.builder()
               .nameFood(nameFood)
               .price(price)
               .image(image)
               .status(status)
               .build();
    }
}