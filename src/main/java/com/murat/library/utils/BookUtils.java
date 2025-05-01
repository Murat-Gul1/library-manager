package com.murat.library.utils;

public class BookUtils {
    private BookUtils(){
        // Utility class, no instantiation
    }
    /**
     * Validates that the input is not null or blank.
     *
     * @param input     the input string to validate
     * @param fieldName the name of the field (used in error messages)
     * @return trimmed input string if valid
     * @throws IllegalArgumentException if the input is null or blank
     */
    public static String validateBasicText(String input, String fieldName){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
        return input.trim();
    }
    /**
     * Validates that the input is not null, not blank, and does not contain any digits.
     *
     * @param input     the input string to validate
     * @param fieldName the name of the field (used in error messages)
     * @return trimmed input string if valid
     * @throws IllegalArgumentException if input is null, blank, or contains digits
     */
    public static String validateNameText(String input, String fieldName){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
        if(input.matches(".*\\d.*")){
            throw new IllegalArgumentException(fieldName + " cannot contain numbers.");
        }
        return input.trim();
    }
    /**
     * Validates that the page count is a positive integer and does not exceed a reasonable limit.
     *
     * @param pageCount the number of pages
     * @return the page count if valid
     * @throws IllegalArgumentException if page count is zero, negative, or unrealistically high
     */
    public static int validatePageCount(int pageCount){
        if(pageCount <= 0 || pageCount >10000){
            throw new IllegalArgumentException("Page count must be between 1 and 10,000.");
        }
        return pageCount;
    }
    /**
     * Validates a level value (1–10) used for scareLevel, spiceLevel, etc.
     *
     * @param level the level to validate
     * @return the same level if valid
     * @throws IllegalArgumentException if level is not in the 1–10 range
     */
    public static int validateLevel1to10(int level){
        if(level < 1 || level > 10){
            throw new IllegalArgumentException("Level must be between 1 and 10");
        }
        return level;
    }
}
