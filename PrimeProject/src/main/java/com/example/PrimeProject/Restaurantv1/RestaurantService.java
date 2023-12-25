package com.example.PrimeProject.Restaurantv1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(final RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Long getsAverageScore(Long id) {
        Optional<Restaurant> restaurantToBeUsed = restaurantRepository.findById(id);
        Restaurant usedRestaurant = restaurantToBeUsed.get();
        Long averageScore = (long) ((usedRestaurant.getPeanutScore() + usedRestaurant.getEggScore() +usedRestaurant.getDairyScore())) / 3;
        return averageScore;
    }

    public List<Restaurant> getAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        Optional<Restaurant> restaurantToFindOptional = this.restaurantRepository.findById(id);

        if(!restaurantToFindOptional.isPresent()){
            System.out.println("Restaurant Not Found");;
        }

        Restaurant restaurantToFind = restaurantToFindOptional.get();
        return restaurantToFind;
    }

    public Restaurant createNewRestaurant(Restaurant restaurant){
        Optional<Restaurant> restaurantToCreateOptional = this.restaurantRepository.findRestaurantById(restaurant.getId());

        if(restaurantToCreateOptional.isPresent()){
            throw new IllegalStateException("Restaurant Already Exists");
        }

        return this.restaurantRepository.save(restaurant);

    }

    public void deleteRestaurant(Long id){
        Optional<Restaurant> restaurantToDeleteOptional = this.restaurantRepository.findById(id);
        if(!restaurantToDeleteOptional.isPresent()){
//            System.out.println("Restaurant does not exist");
            throw new IllegalStateException(String.valueOf(HttpStatus.NO_CONTENT));
        }

        Restaurant restaurantToDelete = restaurantToDeleteOptional.get();
        this.restaurantRepository.delete(restaurantToDelete);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurant){
        Optional<Restaurant> restaurantToUpdateOptional = this.restaurantRepository.findById(id);

        if(!restaurantToUpdateOptional.isPresent()){
            throw new IllegalStateException("Restaurant does not exist");
        }

        Restaurant restaurantToUpdate = restaurantToUpdateOptional.get();
        if (restaurant.getPersonSubmitting() != null){
            restaurantToUpdate.setPersonSubmitting(restaurant.getPersonSubmitting());
        }

        if(restaurant.getPeanutScore() != null){
            restaurantToUpdate.setPeanutScore(restaurant.getPeanutScore());
        }

        if (restaurant.getEggScore() != null){
            restaurantToUpdate.setPeanutScore(restaurant.getPeanutScore());
        }

        if(restaurant.getDairyScore() != null){
            restaurantToUpdate.setDairyScore(restaurant.getDairyScore());
        }

        if(restaurant.getComment() != null){
            restaurantToUpdate.setComment(restaurant.getComment());
        }

        if(restaurant.getPersonZipCode() != null){
            restaurantToUpdate.setPersonZipCode(restaurant.getPersonZipCode());
        }

        if(restaurant.getPersonState() != null){
            restaurantToUpdate.setPersonState(restaurant.getPersonState());
        }

        if(restaurant.getPersonCity() != null){
            restaurantToUpdate.setPersonCity(restaurant.getPersonCity());
        }

        if(restaurant.getInterestInPeanutAllergies() != null){
            restaurantToUpdate.setInterestInPeanutAllergies(restaurant.getInterestInPeanutAllergies());
        }

        if(restaurant.getInterestInDairyAllergies() != null){
            restaurantToUpdate.setInterestInDairyAllergies(restaurant.getInterestInDairyAllergies());
        }

        if(restaurant.getInterestInEggAllergies() != null){
            restaurantToUpdate.setInterestInEggAllergies(restaurant.getInterestInEggAllergies());
        }

        Restaurant updatedRestaurant = restaurantRepository.save(restaurantToUpdate);
        return updatedRestaurant;
    }
}
