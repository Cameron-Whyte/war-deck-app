package com.cameron.deckfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int elixirCost;
    @JsonProperty("rarity")
    private String rarity;
    @Embedded
    private IconUrls iconUrls;

    @ManyToMany(mappedBy = "cards")
    private Set<Category> categories;

    public Card(){
        // constructor without fields necessary for JPA
    }

    public Card(String name, Long id, int elixirCost, String rarity, IconUrls iconUrls) {
        this.name = name;
        this.id = id;
        this.elixirCost = elixirCost;
        this.rarity = rarity;
        this.iconUrls = iconUrls;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getElixirCost() {
        return elixirCost;
    }

    public void setElixirCost(int elixirCost) {
        this.elixirCost = elixirCost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public IconUrls getIconUrls() {
        return iconUrls;
    }

    public void setIconUrls(IconUrls iconUrls) {
        this.iconUrls = iconUrls;
    }

    public Set<Category> getCategories() { return categories; }

    public void setCategories(Set<Category> categories) { this.categories = categories; }
}





