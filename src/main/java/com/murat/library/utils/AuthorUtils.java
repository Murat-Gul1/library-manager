package com.murat.library.utils;
import java.time.LocalDate;

public class AuthorUtils {

    /**
     * Validates the birth year of an author.
     *
     * @param year the year of birth to validate
     * @return the validated year of birth, or 0 if invalid
     */
    public static int validateBirthYear(int year){
        int currentYear = LocalDate.now().getYear();
        try{
            if(year > currentYear){
                throw new Exception("Birth year cannot be in the future. Current year is " + currentYear + ", you entered: " + year);    
        }if(year < 0){
            throw new Exception("Birth year cannot be negative. You entered: " + year);
        }
        return year;
    }catch(Exception e){
        System.out.println("Invalid year of birth");
        return 0;
    }

}

    /**
     * Validates the death year of an author.
     *
     * @param birthYear the birth year of the author
     * @param deathYear the year of death to validate
     * @return the validated year of death, or -1 if the author is still alive
     */
    public static int validateDeathYear(int birthYear ,int deathYear){
        int currentYear = LocalDate.now().getYear();
        try{
        if(deathYear == -1){
                return -1;
        }
        if(deathYear > currentYear){
            throw new Exception("Death year cannot be in the future. Current year is " + currentYear + ", you entered: " + deathYear);
        }if(deathYear <= birthYear){
            throw new Exception("Death year cannot be before birth year. Birth year is " + birthYear + ", you entered: " + deathYear);
        }
        return deathYear;
    }catch(Exception e){
        System.out.println("Invalid year of death");
        return 0;
    }

    }
}