package com.example.PrimeProject.AdminReview;

import com.example.PrimeProject.Restaurantv1.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminReviewRepository extends JpaRepository<Restaurant, Long> {

}
