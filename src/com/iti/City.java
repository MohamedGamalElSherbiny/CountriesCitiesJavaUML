package com.iti;

import java.util.Comparator;

class City {

    private final int code;
    private final String name;
    private final String continent;
    private final int population;
    private final boolean isCapital;

    public City(int code, String name, String continent, int population, boolean isCapital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.isCapital = isCapital;
    }

    public int getCode() {
        return code;
    }


    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    @Override
    public String toString() {
        return "City's name is :" + name + " ,in continent " + continent + " ,and population = " + population +
                " ,and this city is a capital: " + isCapital + ".";
    }

    public static Comparator<City> CityPopulation = (s1, s2) -> s2.getPopulation() - s1.getPopulation();
}
