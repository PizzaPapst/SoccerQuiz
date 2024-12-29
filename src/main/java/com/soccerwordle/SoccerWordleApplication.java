package com.soccerwordle;

import com.soccerwordle.soccer.service.TeamService;
import com.soccerwordle.soccer.api.consume.FootballApiService;
import com.soccerwordle.country.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoccerWordleApplication implements CommandLineRunner {

    // Autowire die benötigten Services
    @Autowired
    private FootballApiService footballApiService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ImgService imgApi;

    public static void main(String[] args) {
        SpringApplication.run(SoccerWordleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Instanziiere ImgApi
        String result = imgApi.getCountryInfo("germany");
        System.out.println(result);

        try {
            // Soccer API aufrufen
            // Team team = teamService.getTeam("Borussia Dortmund");
            // System.out.println("Team: " + team.getName() + " Logo Byte Array Length: " + team.getLogoByteArray().length);
            // Team team = teamService.getRandomTeam();
            // System.out.println(team.getName());
        } catch (Exception e) {
            System.err.println("Fehler beim Abrufen der Soccer API-Daten: " + e.getMessage());
        }
    }
}
