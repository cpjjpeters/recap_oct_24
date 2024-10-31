package be.ipeters.recap.controller;

import be.ipeters.recap.model.City;
import be.ipeters.recap.service.CityJpaPersistenceService;
import be.ipeters.recap.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
@Slf4j
@Controller
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

//    private final CityJpaPersistenceService cityJpaPersistenceService;
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

//    public CityController(CityJpaPersistenceService cityJpaPersistenceService) {
//        this.cityJpaPersistenceService = cityJpaPersistenceService;
//    }

    @GetMapping
    public String showAllCities(Model model) {
        log.debug("getmapping showAllCities");
        var cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "cities/list-cities";
    }
    @GetMapping("/new")
    public String displayCityForm(Model model) {
        log.debug("displayCityForm");
        City aCity = new City();
        model.addAttribute("city", aCity);
        return "cities/new-city";
    }

    @PostMapping("/save")
    public String createCity(City city,Model model) {
        log.debug("createCity");
        cityService.save(city);
        return "cities/new-city";
    }

//    @PostMapping("/save")
//    public void createCity(City city) {
//        cityJpaPersistenceService.save(city);
////        return "redirect:/steden";
//    }
}
