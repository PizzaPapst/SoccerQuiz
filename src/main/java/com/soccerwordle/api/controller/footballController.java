package com.soccerwordle.api.controller;

import com.soccerwordle.TeamService;
import com.soccerwordle.api.football.FootballApiService;
import com.soccerwordle.api.football.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class footballController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/getRandomTeam")
    public Team getTeam() {
       /* Team exampleTeam = new Team(
                1,
                "FC Barcelona",
                "Spain",
                1899,
                "https://example.com/logo/fc-barcelona.png",
                "Barcelona"
        );
        return exampleTeam;*/
         return teamService.getRandomTeam();
    }

}
