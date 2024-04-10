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
/* should maybe move this to other controllers, don't quite know its purpose yet.
   probably a standard home page with button to start selecting cards plus info
   on the app and api used. Maybe some dynamic imaging for flair if possible...
 */