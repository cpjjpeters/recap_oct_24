package be.ipeters.recap.controller;


import be.ipeters.recap.model.City;
import be.ipeters.recap.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/app-api/cities")
public class CityApiController {
    private final CityService cityService;

    public CityApiController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/all")
    public List<City> findAll() {
        log.debug("findAll");
        return cityService.findAll();
    }

    @GetMapping
    public List<City> findDefault() {
        log.debug("findDefault");
        return cityService.findAll();
    }

    @GetMapping(value = "/{id}")
//    public City findById(@PathVariable(value = "id") Long id) {//} throws ResourceNotFoundException {
        public ResponseEntity<City> findById(@PathVariable(value = "id") Long id) {//} throws ResourceNotFoundException {
            log.debug("findById");
        City city = cityService.findById(id);
//        return city;
        return ResponseEntity.ok().body(city);
//        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @PostMapping("/create")
//    public City createCity(@RequestBody City city) {
       public ResponseEntity<City> createCity(@RequestBody City city){
        log.debug("create new City");
//        return cityService.save(city);
        return ResponseEntity.ok().body(cityService.save(city));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<City> update(@PathVariable("id") Long id, @RequestBody City updateCity) {
        log.debug("update");
        City city = cityService.findById(id);
        city.setId(updateCity.getId());
        city.setName(updateCity.getName());
        city.setPopulation(updateCity.getPopulation());
        final City updatedCity =  cityService.update(city);
        return ResponseEntity.ok().body(updatedCity);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Map<String, Boolean> deleteById(@PathVariable("id") Long id) {

        City city = cityService.findById(id);
        log.debug("deleteById {} for {}", id, city.getName());
        cityService.delete(city);
//        cityService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable("id") Long id){
        log.debug("delete with just an id: {}", id);
        cityService.deleteById(id);
    }
}
