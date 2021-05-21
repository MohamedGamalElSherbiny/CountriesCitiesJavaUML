package com.iti;

import java.util.*;

public class LinkCityCountry {
    private ArrayList<Country> countryList = new ArrayList<>();
    private static final HashMap<Integer, List<City>> countries = new HashMap<>();
    private final List<City> mostPopulatedCities = new ArrayList<>();
    private final String[] continents = {"Africa", "Asia", "Europe"};

    public void returnCity(String[] fileDestinations){
        ReadCSV readCSV = new ReadCSV();
        readCSV.CountryInfoDAP(fileDestinations);
        List<City> cityList = readCSV.getCityList();
        countryList = readCSV.getCountryList();
        for (Country value : countryList) {
            int countryCode = value.getCode();
            List<City> cities = new LinkedList<>();
            for (City city : cityList) {
                int cityCode = city.getCode();
                if (countryCode == cityCode) {
                    cities.add(city);
                }
            }
            countries.put(countryCode, cities);
        }
        for(int i =0; i<countries.size(); i++){
            mostPopulatedCities.add(countries.get(i).stream().findFirst().orElseThrow());
        }
    }

    public void printCountryDescending(){
        for(int i =0; i<countries.size(); i++){
            System.out.println("Country is : " + countryList.get(i).getName());
            System.out.println("**************************************");
            for(City city : countries.get(i))
                System.out.println(city);
            System.out.println("**************************************");
        }
    }

    public void highestPopulatedPerCountry(){
        System.out.println("Highest populated city in each country is: ");
        for(City mostPopulatedCity: mostPopulatedCities)
            System.out.println(mostPopulatedCity);
    }

    public void highestPopulatedPerContinent(){
        System.out.println("Highest Populated city in each continent is: ");
        for(String continent : continents) {
            City mostPopulatedCityContinent = mostPopulatedCities.stream().filter(city -> city.getContinent().equals(continent)).min(City.CityPopulation).orElseThrow();
            System.out.println(mostPopulatedCityContinent);
        }
    }

    public void highestPopulatedCapital(){
        City mostPopulatedCapitalCity = mostPopulatedCities.stream().filter(City::isCapital).findFirst().orElseThrow();
        System.out.println("Most populated Capital City in the world is: ");
        System.out.println(mostPopulatedCapitalCity.toString());
    }
}



