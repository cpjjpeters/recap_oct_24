package be.ipeters.recap.controller;

import be.ipeters.recap.model.City;
import be.ipeters.recap.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
@Slf4j
@Controller
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

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
        return "redirect:/cities";
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteCity(@PathVariable("id") Long id, Model model) {
//        log.debug("deleteCity");
//        cityService.delete(id);
//        return "redirect:/cities";
//    }

    @PutMapping("/edit/{id}")
    public String editCity(@PathVariable("id") Long id, Model model) {
        log.debug("editCity");
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "cities/new-city";
    }

    @GetMapping("/update")
    public String displayCityUpdateForm(@RequestParam("id") long theId, Model model) {

        City city = cityService.findByCityId(theId);

        model.addAttribute("city", city);


        return "cities/new-city";
    }

    @GetMapping("delete")
    public String deleteCity(@RequestParam("id") long theId, Model model) {
        City city = cityService.findByCityId(theId);
        cityService.delete(city);
        return "redirect:/cities";
    }
}
