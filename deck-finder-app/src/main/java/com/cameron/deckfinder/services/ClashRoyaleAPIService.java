package com.cameron.deckfinder.services;

import com.cameron.deckfinder.models.Card;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ClashRoyaleAPIService {

    private final String apiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImY2ZjdiZjE3LWUyM2EtNDNkZS1hMWY2LWVhZjkzZGNlOTU5NSIsImlhdCI6MTcwNDg5NjgzMywic3ViIjoiZGV2ZWxvcGVyLzM0YTZmNDZjLWRmMjAtNTdjMC04OTMwLTQ1NDc0Nzk4Njc5NSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIzMS41NC44LjIzNyJdLCJ0eXBlIjoiY2xpZW50In1dfQ.EX4uHDZAhG4GsyQn3Z65EVM9pT1W386viYdQ2OShjXvXS26-9CG0e-7LhQ4qLZDZoEASGDPa3f6S4EGvsL0NeQ";

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

    public List<Card> getCardData() {
        try {
            String authorizationHeader = "Bearer " + apiKey;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", authorizationHeader);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<ApiResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    entity,
                    ApiResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                ApiResponse apiResponse = response.getBody();
                if (apiResponse != null) {
                    List<Card> items = apiResponse.getItems();
                    System.out.println("Items: " + items);
                    return items;
                } else {
                    System.out.println("Response body is null");
                    return Collections.emptyList();
                }
            } else {
                // Log the error or handle it appropriately
                System.err.println("Error retrieving card data. Status code: " + response.getStatusCode());
                return Collections.emptyList();
            }

        } catch (Exception e) {
            // Log the exception or handle it appropriately
            System.err.println("Exception while retrieving card data: " + e.getMessage());
            System.err.println(e.getCause());
            return Collections.emptyList();
        }
    }
}





