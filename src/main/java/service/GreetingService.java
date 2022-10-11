package service;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingService {
    public static String greeting() {
        return "<h1>핫도그 세개 주세요</h1>";
    }
}
