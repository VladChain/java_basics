package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {

    @RequestMapping("/")
    public String data() {
        return "Current date: " + new Date() + ", " +
                "Random number: " + (int) (100 + Math.random() * 100);
    }
}
