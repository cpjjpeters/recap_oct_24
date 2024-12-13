package be.ipeters.recap.controller;

import be.ipeters.recap.model.City;
import be.ipeters.recap.persistence.CityPersistenceFacade;
import be.ipeters.recap.service.CityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityApiControllerTest {
    CityPersistenceFacade CityPersistenceFacade = new CityPersistenceFacade() {
        @Override
        public City save(City city) {
            return null;
        }

        @Override
        public List<City> findAll() {
            return List.of();
        }

        @Override
        public City findById(Long id) {
            return null;
        }

        @Override
        public void delete(City city) {

        }

        @Override
        public void deleteById(Long id) {

        }

        @Override
        public City update(City city) {
            return null;
        }

        @Override
        public City findByCityId(long theId) {
            return null;
        }
    };

    CityService cityService = new CityService(CityPersistenceFacade );
//    @Test
//    void findAll_shouldReturnAllCities(){ // Example function for our testing; use the 'City' object you have above
//        List<City> cities = cityService.findAll();  // Call your controller method to verify result
//        assertEquals(5, cities.size());  // Test that there are a set number of returned data
//    }

//    @Test // Example function for our testing; use the 'City' object you have above
//    void findById_shouldReturnCity(){
//        City city = cityService.findById(2L);
//        assertEquals(city, );  // Verify HTTP status code
//    }

//    @Test
//    void createCity_shouldCreateCorrectly() { // Example function for our testing; use the 'City' object you have above
//        City createdCity = cityApiController.createCity();  // Call your controller method to verify result
//        assertEquals(createdCity, new City(...));
//
//    }

//    @Test
//    void delete_shouldDeleteCorrectly() { // Example function for our testing; use the 'City' object you have above
//        cityApiController.deleteById(1L);  // Call your controller method to verify result
//        assertTrue(cityService.findById(1L) == null);
//
//    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findDefault() {
    }

    @Test
    void findById() {
    }

    @Test
    void createCity() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteCity() {
    }
}