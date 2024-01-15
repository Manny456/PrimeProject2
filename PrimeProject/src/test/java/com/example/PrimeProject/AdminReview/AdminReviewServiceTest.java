package com.example.PrimeProject.AdminReview;

import com.example.PrimeProject.Restaurantv1.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AdminReviewServiceTest {

    @Mock
    AdminReviewRepository adminReviewRepository;

    @InjectMocks
    AdminReviewService adminReviewService;

    @Test
    public void ReturnsCorrectAdminReview() {

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

        adminReviewRepository.save(restaurant);

        //When
        when(adminReviewRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        String expected = "This is a luxury 4 star restaurant";
        String returnedString = adminReviewService.getsTheAdminReview(restaurant.getId());

        //Then
        System.out.println(returnedString);
        assertThat(expected).isEqualTo(returnedString);


    }

}