package com.soccerwordle.api.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponse {
    private Name name;
    private String region;
    private List<String> capital;

    // Getter und Setter
    public Name getName() {
        return name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
