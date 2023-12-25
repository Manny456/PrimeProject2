package com.example.PrimeProject.AdminReview;

import com.example.PrimeProject.Restaurantv1.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminReviewService {

    Restaurant restaurant;

    final AdminReviewRepository adminReviewRepository;

    @Autowired
    public AdminReviewService(final AdminReviewRepository adminReviewRepository) {
        this.adminReviewRepository = adminReviewRepository;
    }

    public String getsTheAdminReview(Long id) {
        Optional<Restaurant> newReviewOptional = adminReviewRepository.findById(id);
        if (!newReviewOptional.isPresent()) {
            return null;
        }

        Restaurant newReview = newReviewOptional.get();

        //Checking for the combined Scores and dividing by 3 which works correctly
        //return (newReview.getDairyScore() + newReview.getEggScore() + newReview.getPeanutScore()) / 3;

        // Checking the condition as a Boolean which should be replicated in the first test
        //return (newReview.getDairyScore() + newReview.getEggScore() + newReview.getPeanutScore()) / 3 >= 3;

        if ((newReview.getEggScore() + newReview.getPeanutScore() + newReview.getDairyScore()) / 3 < 3) {

            return "Restaurant Score is Sub par";

        } else if ((newReview.getEggScore() + newReview.getPeanutScore() + newReview.getDairyScore()) / 3 == 3) {

            return "This is a 3 star restaurant";

        } else if ((newReview.getEggScore() + newReview.getPeanutScore() + newReview.getDairyScore()) / 3 == 4) {
            return "This is a luxury 4 star restaurant";
        }


        return "This is a top of the end 5 star restaurant!";


    }

    public Integer returnRestaurantScore(Long id) {
        Optional<Restaurant> newReviewOptional = adminReviewRepository.findById(id);
        if (!newReviewOptional.isPresent()) {
            return null;
        }

        Restaurant newReview = newReviewOptional.get();

        //Checking for the combined Scores and dividing by 3 which works correctly
        return (newReview.getDairyScore() + newReview.getEggScore() + newReview.getPeanutScore()) / 3;
    }


}
