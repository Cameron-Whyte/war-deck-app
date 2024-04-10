package com.cameron.deckfinder.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarDeck {
    public static final int DECK_LIMIT = 8; // A deck cannot have more than 8 cards
    private final List<Card> cards = new ArrayList<>();
    private final Set<String> uniqueCardNames = new HashSet<>(); // this was static but that would've caused persistence issues

    // add a card to the war deck according to constraints
    public boolean addCard(Card card) {
        if (cards.size() < DECK_LIMIT && !uniqueCardNames.contains(card.getName())) {
            cards.add(card);
            uniqueCardNames.add(card.getName());
            return true; // Successfully added
        }
        return false; // Not added due to constraints
    }

    // get the cards in the war deck
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




