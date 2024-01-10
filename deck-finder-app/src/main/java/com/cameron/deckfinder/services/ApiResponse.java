package com.cameron.deckfinder.services;
import com.cameron.deckfinder.models.Card;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    private List<Card> items;

    @JsonProperty("items")
    public List<Card> getItems() {
        return items;
    }

    public void setItems(List<Card> items) {
        this.items = items;
    }
}


