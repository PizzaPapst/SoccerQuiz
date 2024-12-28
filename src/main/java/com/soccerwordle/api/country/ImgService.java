package com.soccerwordle.api.country;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ImgService {
    private final RestTemplate restTemplate;

    public ImgService() {
        this.restTemplate = new RestTemplate();
    }

    public String getCountryInfo(String countryName) {
        try {
            // Baue die URL
            String url = UriComponentsBuilder
                    .fromHttpUrl("https://restcountries.com/v3.1/name/" + countryName)
                    .queryParam("fullText", "true")
                    .toUriString();

            // API-Aufruf und Deserialisierung in ein Array
            CountryResponse[] response = restTemplate.getForObject(url, CountryResponse[].class);

            if (response != null && response.length > 0) {
                CountryResponse country = response[0];
                return "Land: " + country.getName().getCommon() + ", Region: " + country.getRegion() + ", Hauptstadt: " + country.getCapital().getFirst();
            } else {
                return "Keine Daten für das angegebene Land gefunden!";
            }
        } catch (Exception e) {
            return "Fehler beim Abrufen der Daten: " + e.getMessage();
        }
    }
}
