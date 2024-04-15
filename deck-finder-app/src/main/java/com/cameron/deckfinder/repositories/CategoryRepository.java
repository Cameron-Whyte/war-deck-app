package com.cameron.deckfinder.repositories;

import com.cameron.deckfinder.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
