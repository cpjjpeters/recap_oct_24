package be.ipeters.recap.controller;

import be.ipeters.recap.common.jpa.CityJpaRepository;
import be.ipeters.recap.common.jpa.entity.CityJpaEntity;
import be.ipeters.recap.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	CityJpaRepository cityJpaRepository;
	
	@GetMapping("/home")
	public String displayHome(Model model) {
//		Iterable<Project> projects = proRepo.findAll(); //standard, but then we define a List in the Repository
		List<CityJpaEntity> cities = cityJpaRepository.findAll();
		model.addAttribute("citiesList",cities);
		return "main/home";
	}

}
