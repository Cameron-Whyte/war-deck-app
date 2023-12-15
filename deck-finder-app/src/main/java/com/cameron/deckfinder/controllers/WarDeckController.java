package com.cameron.deckfinder.controllers;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.WarDeck;
import com.cameron.deckfinder.services.ClashRoyaleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WarDeckController {

    private final ClashRoyaleAPIService clashRoyaleAPIService;

    @Autowired
    public WarDeckController(ClashRoyaleAPIService clashRoyaleAPIService) {
        this.clashRoyaleAPIService = clashRoyaleAPIService;
    }

    // Endpoint to display the card selection form
    @GetMapping("/select-cards")
    public String showCardSelectionForm(Model model) {
        Card availableCards = clashRoyaleAPIService.getCardData();
        model.addAttribute("availableCards", availableCards);
        model.addAttribute("warDeck", new WarDeck());

        return "select-cards";
    }



    // Endpoint to handle the form submission
    @PostMapping("/select-cards")
    public String submitCardSelectionForm(@ModelAttribute WarDeck warDeck, Model model) {
        // Implement logic to process the selected cards and update the war deck
        // For now, let's assume you have a service method for adding cards to the war deck
        // You can replace this with your actual logic

        // Example:
        // warDeckService.addCard(c); // c being the card in question

        model.addAttribute("warDeck", warDeck);

        return "selected-cards"; // Thymeleaf template name
    }
}

