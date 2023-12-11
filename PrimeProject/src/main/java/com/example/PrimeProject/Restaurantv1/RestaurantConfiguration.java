package com.example.PrimeProject.Restaurantv1;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RestaurantConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(RestaurantRepository restaurantRepository){
        return args ->{
            Restaurant firstExample = new Restaurant(
                    "Eman",
                    5,
                    5,
                    5,
                    "Highly Recommend this Restaurant",
                    true,
                    "MK9 1UP",
                    "BuckinghamShire",
                    "Milton Keynes",
                    false,
                    false,
                    true
                    );
            Restaurant secondExample = new Restaurant(
                    "Kevs",
                    3,
                    4,
                    2,
                    "Not as good as expected",
                    false,
                    "SL1 2OP",
                    "Berkshire",
                    "Slough",
                    true,
                    true,
                    true
            );
            restaurantRepository.saveAll(List.of(firstExample, secondExample));
        };
    }
}
