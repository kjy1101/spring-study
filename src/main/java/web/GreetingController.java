package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/test")
    public String getMessage(Model model){
        model.addAttribute("testSTR", "왜 타임리프라고 읽나요");
        return "testView";
    }
}
