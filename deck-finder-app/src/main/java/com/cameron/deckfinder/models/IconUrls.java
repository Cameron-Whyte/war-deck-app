package com.cameron.deckfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;

// keeping this as separate class from Card model as it previously had the second url for evolution medium,
// which may be added again in future.

public class IconUrls {
    private String medium;

    // constructor was added for testing in memory storing of cards for /selected-cards endpoint but may not needed
    public IconUrls(){
        this.medium = getMedium();
    }

    @JsonProperty("medium")
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
