package com.example.PrimeProject.Restaurantv1;

import ch.qos.logback.core.net.server.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @Test
    public void RestaurantService_GetAllRestaurants_ReturnsAllRestaurants() {
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);
        //When

        when(restaurantRepository.findAll()).thenReturn(of(restaurant));


        //Then
        List<Restaurant> restaurantToReturn = restaurantService.getAllRestaurants();
        assertThat(restaurantToReturn).isNotNull();
    }

    @Test
    public void RestaurantService_CreateNewClient_ReturnsANewClient() {
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
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
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        restaurantRepository.save(restaurant);
        restaurantRepository.save(restaurant2);
        //When
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant savedRestaurant = restaurantService.createNewRestaurant(restaurant);
        //Then
        Assertions.assertEquals(savedRestaurant, restaurant);
        assertThat(savedRestaurant).isEqualTo(restaurant);
    }

    @Test
    public void RestaurantService_FindRestaurantById_ReturnsRestaurantById() {
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
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
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        //When
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));

        Restaurant restaurantToReturn = restaurantService.getRestaurantById(restaurant.getId());

        //Then
        assertThat(restaurantToReturn).isEqualTo(restaurant);
    }

    @Test
    public void RestaurantService_DeleteRestaurant_DeletesRestaurantById() {
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        //When
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));

        //Then
        assertAll(() -> restaurantService.deleteRestaurant(restaurant.getId()));
    }

    @Test
    public void RestaurantService_UpdateAClient_ReturnsNewClient() {
        //Given
        Restaurant restaurant = Restaurant.builder()
                .personSubmitting("person")
                .peanutScore(3)
                .eggScore(4)
                .dairyScore(5)
                .comment("Meh")
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
                .personZipCode("SL1 9BH")
                .personState("Slough")
                .personCity("Berkshire")
                .interestInPeanutAllergies(true)
                .interestInEggAllergies(false)
                .interestInDairyAllergies(true).build();

        //When
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant2);

        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant.getId(), restaurant2);

        //Then
        verify(restaurantRepository, times(1)).findById(restaurant.getId());
        assertThat(updatedRestaurant).isEqualTo(restaurant2);
    }
}