package com.example.gamebackend.model;


import java.util.List;

public class Country {
    private String name;
    private String capital;
    private List<String> cities;
    private String flag;
    private String plateCode;

    public Country() {
    }

    public Country(String name, String capital, List<String> cities, String flag, String plateCode) {
        this.name = name;
        this.capital = capital;
        this.cities = cities;
        this.flag = flag;
        this.plateCode = plateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }
}