package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/param")
    public String paramTest(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "param";
    }

    @GetMapping("/string")
    @ResponseBody
    public String stringTest(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello " + name;
    }

    @GetMapping("/api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    
    static class Hello {
        private String name; // 외부에서 접근 x => 라이브러리나 아래 메소드를 통해 접근

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
