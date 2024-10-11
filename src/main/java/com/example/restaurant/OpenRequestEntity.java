package com.example.restaurant;

import com.example.restaurant.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenRequestEntity extends BaseEntity {
    private String nameRestaurant;
    private String restNumber;
    private String imageRestNumber;
    private String imageId;
    private String ownerName;
    private String status;


    @OneToMany(mappedBy = "user")
    private UserEntity user;



}
