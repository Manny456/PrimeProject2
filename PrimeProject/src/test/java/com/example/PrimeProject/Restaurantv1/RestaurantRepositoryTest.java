package com.example.PrimeProject.Restaurantv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class RestaurantRepositoryTest {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantRepositoryTest(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    public void RestaurantRepository_SaveAll_ReturnsSavedRestaurants(){

        String person = "Emmanuel";
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting(person)
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        Restaurant savedRestaurant  = restaurantRepository.save(restaurant);

        assertThat(savedRestaurant.getId()).isGreaterThan(0);
    }

    @Test
    public void RestaurantRepository_GetAll_MustReturnMoreThanOneRestaurant(){

        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        Restaurant restaurant2 = Restaurant.builder()
                .personSubmitting("person2")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);
        restaurantRepository.save(restaurant2);

        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        assertThat(allRestaurants.size()).isGreaterThan(0);
    }

    @Test
    public void RestaurantRepository_FindById_ReturnRestaurantById() {

        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);

        Restaurant restaurantIdToReturn = restaurantRepository.findById(restaurant.getId()).get();

        assertThat(restaurantIdToReturn).isNotNull();
    }

    @Test
    public void RestaurantRepository_UpdatingRestaurant_ReturnsUpdatedRestaurant() {
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);

        Restaurant restaurantToBeUpdated = restaurantRepository.findById(restaurant.getId()).get();
        restaurantToBeUpdated.setPersonSubmitting("Jack");

        assertThat(restaurantToBeUpdated.getPersonSubmitting()).isEqualTo("Jack");
    }

    @Test
    public void RestaurantRepository_RestaurantToBeDeleted_MustBeEmpty() {
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .isReviewAccepted(true)
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);
        restaurantRepository.deleteById(restaurant.getId());
        Optional<Restaurant> deletedRestaurant = restaurantRepository.findById(restaurant.getId());

        assertTrue(deletedRestaurant.isEmpty());
    }
}