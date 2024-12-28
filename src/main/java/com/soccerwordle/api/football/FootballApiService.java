package com.soccerwordle.api.football;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class FootballApiService {


    private String apiKey = "8dc61a609fdcd77d4156b7923a5444e6";

    private final RestTemplate restTemplate;

    public FootballApiService() {
        this.restTemplate = new RestTemplate();
    }

    public String getLeagues() {
        String url = "https://v3.football.api-sports.io/leagues";

        // Header für API-Schlüssel
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Anfrage an die API
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Antwort zurückgeben
        return response.getBody();
    }

    public Team getTeam(String teamName) {
        String url = "https://v3.football.api-sports.io/teams?name=" + teamName;

        // Header für API-Schlüssel
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Anfrage an die API
        ApiResponseTeam response = restTemplate.exchange(url, HttpMethod.GET, entity, ApiResponseTeam.class).getBody();
        int id = response.getResponse().getFirst().getTeam().getId();
        String name = response.getResponse().getFirst().getTeam().getName();
        String country = response.getResponse().getFirst().getTeam().getCountry();
        int founded = response.getResponse().getFirst().getTeam().getFounded();
        String logo = response.getResponse().getFirst().getTeam().getLogo();
        String city = response.getResponse().getFirst().getVenue().getCity();

        Team team = new Team(id, name, country, founded, logo, city);

        // Antwort zurückgeben
        return team;
    }
}
