package com.cameron.deckfinder.repositories;

import com.cameron.deckfinder.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CardRepository extends JpaRepository<Card, Long> {
}
