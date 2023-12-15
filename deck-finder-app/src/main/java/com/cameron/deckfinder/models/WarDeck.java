package com.cameron.deckfinder.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarDeck {
    private static final int TOTAL_CARDS_LIMIT = 32; // Total number of unique cards across all war decks
    private static final int DECK_LIMIT = 8; // A deck cannot have more than 8 cards
    private final List<Card> cards;
    private static final Set<String> uniqueCardNames = new HashSet<>();

    // Constructor
    public WarDeck() {
        this.cards = new ArrayList<>();
    }

    // Method to add a card to the war deck
    public void addCard(Card card) {
        if (cards.size() < DECK_LIMIT && uniqueCardNames.size() < TOTAL_CARDS_LIMIT && !uniqueCardNames.contains(card.getName())) {
            cards.add(card);
            uniqueCardNames.add(card.getName());
        } else {
            System.out.println("Cannot add more cards. War deck is full or the card is not unique.");
        }
    }

    // Method to get the cards in the war deck
    public List<Card> getCards() {
        return cards;
    }

    // toString method for easy debugging or logging
    @Override
    public String toString() {
        return "WarDeck{" +
                "cards=" + cards +
                '}';
    }
}



