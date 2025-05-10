package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a historical book in the library system.
 * <p>
 * In addition to common {@link Book} fields, this class stores:
 * <ul>
 *   <li>{@code eraStartYear} – the starting year of the historical period depicted</li>
 *   <li>{@code region} – the geographic area or empire relevant to the story</li>
 * </ul>
 * Each instance is assigned a unique {@code libraryCode} generated via timestamp + random + counter.
 */
public class HistoricalBook extends Book{
    private String eraStartYear;

    /** Geographic region for the historical narrative (e.g. "Empire"). */
    private String region;

    /** System-generated unique identifier for this book. */
    private final  String libraryCode;

    /** Counter used to ensure uniqueness in code generation. */
    private static final AtomicInteger counter = new AtomicInteger();

    /** Random component to further reduce collision risk. */
    private static final Random random = new Random();

    /**
     * Generates a unique library code for a historical book.
     * <p>
     * Format: BK-HIyyyyMMddHHmmssSSS-<random>-<counter>
     *
     * @return a unique string identifier
     */
    private static String generateCode(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);

        int count = counter.getAndIncrement();

        return "Bk-HI" + timestamp +"-" + String.format("%03d",randomPart) +"-" +count;
    }

    /**
     * Constructs a new {@code HistoricalBook} with specified metadata and era details.
     *
     * @param title         the book’s title
     * @param author        the author’s name
     * @param pageCount     total number of pages (validated in {@link Book})
     * @param category      the general category label (e.g. "History")
     * @param borrowedDate  date the book was borrowed (nullable)
     * @param returnDate    expected return date (nullable)
     * @param eraStartYear  the year when the historical era begins (non-blank text)
     * @param region        the region or empire setting (non-blank text)
     * @throws IllegalArgumentException if any input validation fails
     */
    public HistoricalBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,String eraStartYear,String region){
        super(title,author,pageCount,category,borrowedDate,returnDate);
        this.eraStartYear = BookUtils.validateBasicText(eraStartYear,"Start Year");
        this.region = BookUtils.validateBasicText(region,"Region");
        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }

    /**
     * Updates the era start year.
     *
     * @param eraStartYear new era year (non-blank text)
     * @throws IllegalArgumentException if input is blank
     */
    public void setEraStartYear(String eraStartYear){
        this.eraStartYear = BookUtils.validateBasicText(eraStartYear,"Start Year");
    }

    /** @return the era start year as provided (non-blank string) */
    public String getEraStartYear(){
        return eraStartYear;
    }

    /**
     * Updates the region for this historical book.
     *
     * @param region new region label (non-blank text)
     * @throws IllegalArgumentException if input is blank
     */
    public void setRegion(String region){
        this.region = BookUtils.validateBasicText(region,"Region");
    }

    /** @return the geographic region of the historical narrative */
    public String getRegion(){
        return region;
    }

    /**
     * Returns the system-generated library code.
     *
     * @return unique libraryCode string
     */
    public String getLibraryCode(){
        return libraryCode;
    }

    /**
     * Returns a formatted string including all book details and historical specifics.
     *
     * @return descriptive book information
     */
    @Override
    public String toString(){
       return super.toString() +
                " | Start Year: " + eraStartYear +
                " | Region: " + region;
    }
}
