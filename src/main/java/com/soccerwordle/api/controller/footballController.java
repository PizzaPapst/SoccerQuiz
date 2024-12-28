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

    @GetMapping("/team/{name}")
    public Team getTeam(@PathVariable String name) {
        return teamService.getTeam(name);
    }

}
