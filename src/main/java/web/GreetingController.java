package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import service.GreetingService;

@Controller
public class GreetingController {
    String result;

    @GetMapping("/greeting")
    public String greeting() {
        result = GreetingService.greeting();
        return result;
    }
}
