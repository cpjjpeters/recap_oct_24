package be.ipeters.recap.controller;


import be.ipeters.recap.model.City;
import be.ipeters.recap.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
//
//    @GetMapping(value = "/{id}")
//    public Optional<City> findById(@PathVariable(value = "id") Long id) {
//        log.debug("");
//        return cityService.findById(id);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> findById(@PathVariable(value = "id") Long id) {//} throws ResourceNotFoundException {
        log.debug("findById");
        City city = cityService.findById(id);
        return ResponseEntity.ok().body(city);
    }
    @PostMapping("/create")
    public City createCity(@RequestBody City city) {
        log.debug("createCity");
        return cityService.save(city);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<City> update(@PathVariable("id") Long id, @RequestBody City updateCity) {
        log.debug("update");
        City city = cityService.findById(id);
//        city.setId(updateCity.getId());
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
}
