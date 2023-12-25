package com.example.PrimeProject.AdminReview;


import com.example.PrimeProject.Restaurantv1.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdminReviewController {

    private final AdminReviewService adminReviewService;

    @Autowired
    public AdminReviewController (final AdminReviewService adminReviewService) {
        this.adminReviewService = adminReviewService;
    }

    @GetMapping("/api/v1/test/{id}")
    public String returnsAString(@PathVariable("id") Long id) {

        return adminReviewService.getsTheAdminReview(id);
    }

    //Returns the average restaurant score.
    @GetMapping("/restaurantScore/{id}")
    public Integer returnScore(@PathVariable("id") Long id) {
        return adminReviewService.returnRestaurantScore(id);
    }

}
