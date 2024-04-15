package com.cameron.deckfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maxLevel;
    private int maxEvolutionLevel;
    private int elixirCost;
    @JsonProperty("rarity")
    private String rarity;
    @Embedded
    private IconUrls iconUrls;

    public Card(){
        // constructor without fields necessary for JPA
    }

    public Card(String name, int id, int maxLevel, int maxEvolutionLevel, int elixirCost, String rarity, IconUrls iconUrls) {
        this.name = name;
        this.id = id;
        this.maxLevel = maxLevel;
        this.maxEvolutionLevel = maxEvolutionLevel;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMaxEvolutionLevel() {
        return maxEvolutionLevel;
    }

    public void setMaxEvolutionLevel(int maxEvolutionLevel) {
        this.maxEvolutionLevel = maxEvolutionLevel;
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

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", maxLevel=" + maxLevel +
                ", maxEvolutionLevel=" + maxEvolutionLevel +
                ", elixirCost=" + elixirCost +
                ", rarity=" + rarity +
                ", iconUrls=" + iconUrls +
                '}';
    }
}





