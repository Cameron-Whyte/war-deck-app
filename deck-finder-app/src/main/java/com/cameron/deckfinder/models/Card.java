package com.cameron.deckfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Card {
    private String name;
    private int id;
    private int maxLevel;
    private int maxEvolutionLevel;
    private int elixirCost;
    private Rarity rarity;
    private IconUrls iconUrls;

    // Constructors
    public Card() {
        // Default constructor
    }

    public Card(String name, int id, int maxLevel, int maxEvolutionLevel, int elixirCost, Rarity rarity, IconUrls iconUrls) {
        this.name = name;
        this.id = id;
        this.maxLevel = maxLevel;
        this.maxEvolutionLevel = maxEvolutionLevel;
        this.elixirCost = elixirCost;
        this.rarity = rarity;
        this.iconUrls = iconUrls;
    }

    // Getters and setters
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("maxLevel")
    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @JsonProperty("maxEvolutionLevel")
    public int getMaxEvolutionLevel() {
        return maxEvolutionLevel;
    }

    public void setMaxEvolutionLevel(int maxEvolutionLevel) {
        this.maxEvolutionLevel = maxEvolutionLevel;
    }

    @JsonProperty("elixirCost")
    public int getElixirCost() {
        return elixirCost;
    }

    public void setElixirCost(int elixirCost) {
        this.elixirCost = elixirCost;
    }

    @JsonProperty("rarity")
    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    @JsonProperty("iconUrls")
    public IconUrls getIconUrls() {
        return iconUrls;
    }

    public void setIconUrls(IconUrls iconUrls) {
        this.iconUrls = iconUrls;
    }

    // Inner classes
    public static class Rarity {
        private String name;

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class IconUrls {
        private String medium;
        private String evolutionMedium;

        @JsonProperty("medium")
        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        @JsonProperty("evolutionMedium")
        public String getEvolutionMedium() {
            return evolutionMedium;
        }

        public void setEvolutionMedium(String evolutionMedium) {
            this.evolutionMedium = evolutionMedium;
        }
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




