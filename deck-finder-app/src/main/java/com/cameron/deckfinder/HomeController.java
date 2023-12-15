package com.cameron.deckfinder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "Welcome to the home of Deck Finder!";
    }
}
