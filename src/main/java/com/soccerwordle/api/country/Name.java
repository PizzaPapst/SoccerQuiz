package com.soccerwordle.api.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private String common;
    private String official;

    // Getter und Setter
    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}
