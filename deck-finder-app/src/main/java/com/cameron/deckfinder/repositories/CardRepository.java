package com.cameron.deckfinder.repositories;

import com.cameron.deckfinder.models.Card;
import com.cameron.deckfinder.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByName(String name);
}
