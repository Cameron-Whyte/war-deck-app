package com.cameron.deckfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IconUrls {
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
