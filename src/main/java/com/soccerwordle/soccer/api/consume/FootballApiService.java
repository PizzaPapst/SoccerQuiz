package com.soccerwordle.soccer.api.consume;

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

    public TeamResponse getTeam(String teamName) {
        String url = "https://v3.football.api-sports.io/teams?name=" + teamName;

        // Header für API-Schlüssel
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Anfrage an die API
        TeamResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, TeamResponse.class).getBody();

        return response;
    }

    public TeamResponse getTeamsFromLeague(int leagueId) {
        String url = "https://v3.football.api-sports.io/teams?league="+leagueId+"&season=2021";

        // Header für API-Schlüssel
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Anfrage an die API
        TeamResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, TeamResponse.class).getBody();

        // Antwort zurückgeben
        return response;
    }


}
