package com.example.PrimeProject.Restaurantv1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {



    Optional<Restaurant> findRestaurantById(Long id);
}

