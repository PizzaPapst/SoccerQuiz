package com.soccerwordle.soccer.model;

public class ClStrikers {
    private String jsonInputString = """
            [
                    {"rank": 1, "player": "Cristiano Ronaldo", "goals": 140, "nationality": "Portugal"},
                    {"rank": 2, "player": "Lionel Messi", "goals": 129, "nationality": "Argentinien"},
                    {"rank": 3, "player": "Robert Lewandowski", "goals": 101, "nationality": "Polen"},
                    {"rank": 4, "player": "Karim Benzema", "goals": 90, "nationality": "Frankreich"},
                    {"rank": 5, "player": "Raúl González", "goals": 71, "nationality": "Spanien"},
                    {"rank": 6, "player": "Ruud van Nistelrooy", "goals": 56, "nationality": "Niederlande"},
                    {"rank": 7, "player": "Thomas Müller", "goals": 55, "nationality": "Deutschland"},
                    {"rank": 8, "player": "Thierry Henry", "goals": 50, "nationality": "Frankreich"},
                    {"rank": 9, "player": "Alfredo Di Stéfano", "goals": 49, "nationality": "Spanien"},
                    {"rank": 10, "player": "Andriy Shevchenko", "goals": 48, "nationality": "Ukraine"}
                ]
            
        """;

    public String getJsonInputString() {
        return jsonInputString;
    }
}
