package com.murat.library.utils;
import java.time.LocalDate;

public class AuthorUtils {

    public static int validateBirthYear(int year){
        int currentYear = LocalDate.now().getYear();
        if(1000 <= year && year <= currentYear){
        return year;
        }else{
            throw new IllegalArgumentException("Invalid year of birth :" + year);
        }
    }

    public static int validateDeathYear(int birthYear ,int deathYear){
        int currentYear = LocalDate.now().getYear();
        if( birthYear <= deathYear && deathYear <= currentYear){
            return deathYear;
        }else{
            throw new IllegalArgumentException("Invalid year of death: " + deathYear);
        }
    }
}
