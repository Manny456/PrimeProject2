package com.example.PrimeProject.AdminReview;

import com.example.PrimeProject.Restaurantv1.Restaurant;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class AdminReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long adminId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    public Boolean isReviewAccepted;

    public AdminReview (Long adminId, Boolean isReviewAccepted){
        this.adminId = restaurant.getId();
        this.isReviewAccepted = isReviewAccepted;
    }
}
