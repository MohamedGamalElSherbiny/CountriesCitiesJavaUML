package com.iti;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

class ReadCSV implements Comparator<City>{

    private final ArrayList<Country> countryList = new ArrayList<>();
    private final List<City> cityList = new ArrayList<>();

    public void CountryInfoDAP(String[] rawFile){
        String[] numberOfFiles = new String[rawFile.length];
        System.arraycopy(rawFile, 0, numberOfFiles, 0, rawFile.length);
        List<String> lines;
        for (String fileName : numberOfFiles) {
            lines = readFile(fileName);
            assert lines != null;
            if (lines.get(0).contains("Country")) {
                addCountry(lines);
            } else if (lines.get(0).contains("City")){
                addCity(lines);
            } else {
                System.out.println("Wrong Data.");
            }
        }
        sortCities();
    }

    public void sortCities(){
//        sortCity.sort(City.CityPopulation);
//        Collections.sort(cityList, this::compare);
        cityList.sort(this);
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    private void addCountry(List<String> lines){
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            int code = Integer.parseInt(fields[0]);
            String name = fields[1];
            Country country = new Country();
            country.setName(name);
            country.setCode(code);
            countryList.add(country);
        }
        System.out.println("Countries successfully added.");
    }

    private void addCity(List<String> lines){
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            City city = new City(Integer.parseInt(fields[0]),
                    fields[1], fields[2],
                    Integer.parseInt(fields[4]), Boolean.parseBoolean(fields[5]));
            cityList.add(city);
        }
        System.out.println("Cities successfully added.");
    }

    private List<String> readFile(String fileName){
        File newFile = new File(fileName);
        try {
            return Files.readAllLines(newFile.toPath());
        } catch (Exception e) {
            System.out.println("There is an error: " + e);
            return null;
        }
    }

    @Override
    public int compare(City c1, City c2) {
        return c2.getPopulation() - c1.getPopulation();
    }
}