package be.ipeters.recap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value="/welcome")
    public @ResponseBody String welcomepage() {
        return "{key:value}";
    }
}

