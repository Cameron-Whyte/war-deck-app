package com.cameron.deckfinder.bootstrap;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.Category;
import com.cameron.deckfinder.models.IconUrls;
import com.cameron.deckfinder.repositories.CardRepository;
import com.cameron.deckfinder.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

// example class for inserting cards into database
@Component
public class DataLoader implements CommandLineRunner {

    private final CardRepository cardRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(CardRepository cardRepository, CategoryRepository categoryRepository) {
        this.cardRepository = cardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Card card1 = new Card("Knight", 26000000, 14, 1, 3, "Common", new IconUrls());
        Category category1 = new Category("Tank");

        Set<Card> cards = new HashSet<>();
        cards.add(card1);
        category1.setCards(cards);

        cardRepository.save(card1);
        categoryRepository.save(category1);
    }
}

