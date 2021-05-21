package com.iti;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fileDestinations = {"src/com/iti/cities.csv",
                "src/com/iti/countries.csv"};
        LinkCityCountry linkCityCountry = new LinkCityCountry();
        linkCityCountry.returnCity(fileDestinations);
        boolean flag = true;
        while (flag){
            System.out.println("""
                    Please choose one of these options:\s
                    1- Exit
                    2- Print all countries and cities in ascending order according to the population
                    3- Print highest populated country in each continent
                    4- Print highest populated capital
                    5- Print highest populated city in each country\s""");
            int userInput = scanner.nextInt();
            if(userInput == 1){
                flag = false;
                System.out.println("Goodbye!");
            }else if(userInput == 2){
                linkCityCountry.printCountryDescending();
            }else if(userInput == 3){
                linkCityCountry.highestPopulatedPerContinent();
            }else if(userInput == 4){
                linkCityCountry.highestPopulatedCapital();
            }else if(userInput == 5){
                linkCityCountry.highestPopulatedPerCountry();
            }else{
                System.out.println("Wrong Number\nPlease try again.");
            }
            System.out.println("*************************************************************************************");
        }
        scanner.close();
    }
}