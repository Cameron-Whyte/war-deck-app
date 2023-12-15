package com.cameron.deckfinder.services;

import com.cameron.deckfinder.models.Card;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClashRoyaleAPIService {

    @Value("${clashroyale.api.key}")
    private String apiKey;

    private final String apiUrl = "https://api.clashroyale.com/v1/cards";

    private final RestTemplate restTemplate;

    public ClashRoyaleAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        configureRestTemplate();
    }

    private void configureRestTemplate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }

    public String getApiKey() {
        return apiKey;
    }

    public Card getCardData() {
        try {
            String authorizationHeader = "Bearer " + apiKey;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", authorizationHeader);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Card> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    Card.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println(response.hasBody());
                System.out.println(response.getBody().toString());
                return response.getBody();
            } else {
                // Log the error or handle it appropriately
                System.err.println("Error retrieving card data. Status code: " + response.getStatusCode());
                return null; // Or throw an exception, or handle the error in another way
            }
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            System.err.println("Exception while retrieving card data: " + e.getMessage());
            return null; // Or throw an exception, or handle the error in another way
        }
    }

}





