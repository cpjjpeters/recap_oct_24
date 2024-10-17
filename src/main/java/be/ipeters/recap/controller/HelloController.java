package be.ipeters.recap.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @GetMapping({"/hallo"})
    public String hello(Model model,
                        @RequestParam(value="name", required=false, defaultValue="World") String name) {
        log.debug("hallo: {}",name);
        model.addAttribute("name", name);
        return "hello";
    }
}
