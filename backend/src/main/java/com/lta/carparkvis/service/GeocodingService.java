package com.lta.carparkvis.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Optional;

@Service
public class GeocodingService {

    private static final Logger logger = LoggerFactory.getLogger(GeocodingService.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private static final String NOMINATIM_API_URL = "https://nominatim.openstreetmap.org/search";

    public GeocodingService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Optional<double[]> geocodeStreet(String street) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(NOMINATIM_API_URL)
                .queryParam("q", street)
                .queryParam("countrycodes", "sg")
                .queryParam("format", "json")
                .queryParam("limit", 1);

        try {
            String response = restTemplate.getForObject(uriBuilder.toUriString(), String.class);
            if (response != null) {
                JsonNode root = objectMapper.readTree(response);
                if (root.isArray() && root.size() > 0) {
                    JsonNode result = root.get(0);
                    double lat = result.get("lat").asDouble();
                    double lon = result.get("lon").asDouble();
                    return Optional.of(new double[]{lat, lon});
                }
            }
        } catch (IOException e) {
            logger.error("Error parsing geocoding response for street: {}", street, e);
        } catch (Exception e) {
            logger.error("Error during geocoding for street: {}", street, e);
        }

        return Optional.empty();
    }
} 