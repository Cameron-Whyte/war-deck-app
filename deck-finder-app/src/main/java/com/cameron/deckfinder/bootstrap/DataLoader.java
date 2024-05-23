package com.cameron.deckfinder.bootstrap;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.Category;
import com.cameron.deckfinder.models.CategoryMapping;
import com.cameron.deckfinder.services.ClashRoyaleAPIService;
import com.cameron.deckfinder.repositories.CardRepository;
import com.cameron.deckfinder.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final CardRepository cardRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final ClashRoyaleAPIService apiService;

    public DataLoader(CardRepository cardRepository, CategoryRepository categoryRepository, ClashRoyaleAPIService apiService) {
        this.cardRepository = cardRepository;
        this.categoryRepository = categoryRepository;
        this.apiService = apiService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        List<Card> cards = apiService.getCardData(); // Fetch cards from the API
        for (Card card : cards) {
            Card existingCard = cardRepository.findByName(card.getName()).orElse(null);
            // Don't want to add a card unless it is not in the database
            if (existingCard == null) {
                existingCard = card;
            } else {
                existingCard.setElixirCost(card.getElixirCost());
                existingCard.setRarity(card.getRarity());
                existingCard.setIconUrls(card.getIconUrls());
            }

            Set<String> categoryNames = CategoryMapping.getCategories(card.getName());
            Set<Category> categories = new HashSet<>();
            for (String categoryName : categoryNames) {
                Category category = categoryRepository.findByName(categoryName)
                        .orElseGet(() -> new Category(categoryName));
                category = categoryRepository.save(category);
                categories.add(category);
                // if categories cards are null initialize a new set of cards
                if (category.getCards() == null) {
                    category.setCards(new HashSet<>());
                }
                // add the cards to the category's set
                category.getCards().add(existingCard);
            }
            existingCard.setCategories(categories);
            cardRepository.save(existingCard);
        }
    }
}


