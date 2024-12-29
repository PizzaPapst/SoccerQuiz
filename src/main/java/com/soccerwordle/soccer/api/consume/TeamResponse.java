package com.soccerwordle.soccer.api.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

// Antwort der API, die die Teams und Stadien enthält
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamResponse {

    private List<ResponseItem> response;

    public List<ResponseItem> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseItem> response) {
        this.response = response;
    }

    // Innere Klasse für das Team und Venue
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseItem {

        private Team team;
        private Venue venue;

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Venue getVenue() {
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

        // Innere Klasse für Team
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Team {

            private int id;
            private String name;
            private String country;
            private int founded;
            private String logo;

            // Getter und Setter
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getFounded() {
                return founded;
            }

            public void setFounded(int founded) {
                this.founded = founded;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }

        // Innere Klasse für Venue
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Venue {

            private String name;
            private String city;
            private int capacity;

            // Getter und Setter
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCapacity() {
                return capacity;
            }

            public void setCapacity(int capacity) {
                this.capacity = capacity;
            }
        }
    }
}
