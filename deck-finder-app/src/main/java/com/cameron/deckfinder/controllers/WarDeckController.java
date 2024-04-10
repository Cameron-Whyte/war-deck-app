package com.cameron.deckfinder.controllers;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.WarDeck;
import com.cameron.deckfinder.services.ClashRoyaleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WarDeckController {

    private final ClashRoyaleAPIService clashRoyaleAPIService;

    @Autowired
    public WarDeckController(ClashRoyaleAPIService clashRoyaleAPIService) {
        this.clashRoyaleAPIService = clashRoyaleAPIService;
    }

    @GetMapping("/select-cards")
    public String showCardSelectionForm(Model model) {
        List<Card> availableCards = clashRoyaleAPIService.getCardData();
        model.addAttribute("availableCards", availableCards);
        return "select-cards";
    }

    @PostMapping("/selected-cards")
    public String handleSelectedCards(@RequestParam List<Integer> selectedCardIds, Model model) {
        // fetch all available cards
        List<Card> allAvailableCards = clashRoyaleAPIService.getCardData();

        // convert selectedCardIds to Card objects
        List<Card> selectedCards = allAvailableCards.stream()
                .filter(card -> selectedCardIds.contains(card.getId()))
                .collect(Collectors.toList());

        // remove selected cards from the pool of available cards to avoid re-adding them
        allAvailableCards.removeAll(selectedCards);

        // prep 4 war decks
        List<WarDeck> warDecks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            warDecks.add(new WarDeck());
        }

        // randomly distribute selected cards across the four decks
        Collections.shuffle(selectedCards);
        for (Card card : selectedCards) {
            boolean added = false;
            Collections.shuffle(warDecks); // shuffle warDecks to randomize distribution
            for (WarDeck warDeck : warDecks) {
                if (warDeck.addCard(card)) {
                    added = true;
                    break;
                }
            }
            if (!added) {
                System.out.println("Failed to add selected card to any deck (due to uniqueness constraint): " + card.getName());
                // need better error handling here
            }
        }

        // the logic below will change once rules are applied on war decks and cards are put into groups

        // pad out the decks with additional cards to ensure each has exactly 8 cards
        Collections.shuffle(allAvailableCards); // shuffle to randomize padding cards
        for (WarDeck warDeck : warDecks) {
            while (warDeck.getCards().size() < WarDeck.DECK_LIMIT && !allAvailableCards.isEmpty()) {
                Card cardToAdd = allAvailableCards.remove(0); // Take the first card
                warDeck.addCard(cardToAdd); // No need to check if added since all cards are now unique
            }
        }

        model.addAttribute("warDecks", warDecks); // add war decks to model
        return "selected-cards";
    }

}
