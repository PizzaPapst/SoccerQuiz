package com.soccerwordle.soccer.api.controller;

import com.soccerwordle.soccer.service.ClService;
import com.soccerwordle.soccer.service.TeamService;
import com.soccerwordle.soccer.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class soccerControler {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ClService clService;

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

    @GetMapping("/getClWinners")
    public String getClWinners() {
        return clService.getClWinners();
    }

    @GetMapping("/getClStrikers")
    public String getClStrikers() {
        return clService.getClStrikers();
    }


}
