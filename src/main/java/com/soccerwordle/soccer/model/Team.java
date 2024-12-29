package com.soccerwordle.soccer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private int id;
    private String name;
    private String country;
    private int founded;
    private String logo;
    private String city;
    private byte[] logoByteArray;

    public Team(int id, String name, String country, int founded, String logo, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.logo = logo;
        this.city = city;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getLogoByteArray() {
        return logoByteArray;
    }

    public void setLogoByteArray(byte[] logoByteArray) {
        this.logoByteArray = logoByteArray;
    }
}


