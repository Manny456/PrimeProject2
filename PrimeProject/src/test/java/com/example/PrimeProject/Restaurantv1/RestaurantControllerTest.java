package com.example.PrimeProject.Restaurantv1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(controllers = RestaurantController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {

    @MockBean
    RestaurantService restaurantService;

    @Autowired
    MockMvc mockMvc;

    @Mock
    RestaurantRepository restaurantRepository;

    private Restaurant restaurant;

    private Restaurant restaurant2;

    @BeforeEach
    public void init() {
        restaurant = Restaurant.builder()
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

        restaurant2 = Restaurant.builder()
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
    }

    @Test
    public void RestaurantController_PostMapping_ReturnNewRestaurant() throws Exception {

        given(restaurantService.createNewRestaurant(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        ObjectMapper objectMapper = new ObjectMapper();
        String clientJson = objectMapper.writeValueAsString(restaurant);

        given(restaurantService.createNewRestaurant(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(post("/api/v1/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test
    public void RestaurantController_GetMapping_MustReturnAllRestaurants() throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();
        String allRestaurants = objectMapper.writeValueAsString(restaurantService.getAllRestaurants());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurants")
                        .content(allRestaurants)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void RestaurantController_GetMapping_MustReturnRestaurantById() throws Exception {

        when(restaurantService.getRestaurantById(restaurant.getId())).thenReturn(restaurant);

        ObjectMapper objectMapper = new ObjectMapper();
        String clientJson = objectMapper.writeValueAsString(restaurant);

        mockMvc.perform((MockMvcRequestBuilders.get("/api/v1/restaurants/1")
                        .content(clientJson))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void RestaurantController_PutMapping_MustUpdateRestaurant() throws Exception {
        when(restaurantService.updateRestaurant(1L, restaurant2)).thenReturn(restaurant2);

        ObjectMapper objectMapper = new ObjectMapper();
        String clientJson = objectMapper.writeValueAsString(restaurant2);

        mockMvc.perform(put("/api/v1/restaurants/1")
                .content(clientJson)
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void RestaurantController_DeleteMapping_MustDeleteRestaurantAndReturnNull() throws Exception {
        doNothing().when(restaurantService).deleteRestaurant(1L);

        mockMvc.perform(delete("/api/v1/restaurants/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}