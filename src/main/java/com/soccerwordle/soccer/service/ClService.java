package com.soccerwordle.soccer.service;

import com.soccerwordle.soccer.model.ClStrikers;
import com.soccerwordle.soccer.model.ClWinners;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClService {

    public String getClWinners() {
        ClWinners clWinners = new ClWinners();
        return clWinners.getJsonInputString();
    }

    public String getClStrikers() {
        ClStrikers clStrikers = new ClStrikers();
        return clStrikers.getJsonInputString();
    }

}
