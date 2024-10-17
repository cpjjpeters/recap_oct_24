package be.ipeters.recap.controller;

import be.ipeters.recap.model.City;
import be.ipeters.recap.service.CityJpaPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
@Slf4j
@Controller
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityJpaPersistenceService cityJpaPersistenceService;

    public CityController(CityJpaPersistenceService cityJpaPersistenceService) {
        this.cityJpaPersistenceService = cityJpaPersistenceService;
    }

    @GetMapping(value="welkom")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        log.debug("Welcome!");
        model.addAttribute("name", name);
        return "welcome";
    }

    @GetMapping(value = {"indeks", "all"})
    public String index(Model model) {
    log.debug("getmapping slash");
        return "index";
    }

    @GetMapping(value="steden")
    public ModelAndView showCities() {
        log.debug("getmapping slash cities");
        var cities = cityJpaPersistenceService.findAll();

        var params = new HashMap<String, Object>();
        params.put("cities", cities);

        return new ModelAndView("showCities", params);
    }

    @PostMapping("/save")
    public void createCity(City city) {
        cityJpaPersistenceService.save(city);
//        return "redirect:/steden";
    }
}
