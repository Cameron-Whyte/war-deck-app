package com.cameron.deckfinder.controllers;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.WarDeck;
import com.cameron.deckfinder.services.ClashRoyaleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WarDeckController {

    private final ClashRoyaleAPIService clashRoyaleAPIService;

    @Autowired
    public WarDeckController(ClashRoyaleAPIService clashRoyaleAPIService) {
        this.clashRoyaleAPIService = clashRoyaleAPIService;
    }

    // Endpoint to display the card selection form
    @GetMapping("/select-cards")
    public String showCardSelectionForm(Model model) {
        List<Card> availableCards = clashRoyaleAPIService.getCardData();
        System.out.println("Available Cards: " + availableCards);
        model.addAttribute("availableCards", availableCards);
        model.addAttribute("warDeck", new WarDeck());

        return "select-cards";
    }



    // Endpoint to handle the form submission
    @PostMapping("/select-cards")
    public String submitCardSelectionForm(@ModelAttribute WarDeck warDeck, Model model) {
        // Implement logic to process the selected cards and update the war deck


        // Example:
        // warDeckService.addCard(c); // c being the card in question

        model.addAttribute("warDeck", warDeck);

        return "selected-cards"; // Thymeleaf template name
    }
}

