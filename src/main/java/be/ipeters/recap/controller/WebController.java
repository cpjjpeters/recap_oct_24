package be.ipeters.recap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* carlpeters created on 28/05/2024 inside the package - be.ipeters.thymeleaf.controller */
@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}