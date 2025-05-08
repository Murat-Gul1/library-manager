package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a science fiction book in the library system.
 * <p>
 * In addition to standard book details, this class includes:
 * <ul>
 *     <li>{@code subGenre} – a specific sci-fi type (e.g. "space opera", "cyberpunk")</li>
 *     <li>{@code scientificLevel} – a value from 1 to 10 indicating how realistic or technical the story is</li>
 * </ul>
 * Each book is assigned a unique library code using the timestamp, a random number, and a counter.
 */

public class ScienceFictionBook extends Book {
    /** Counter for generating unique library codes. */
    private final static AtomicInteger counter = new AtomicInteger();

    /** Random number generator for library code uniqueness. */
    private final static Random random = new Random();

    /** Indicates the scientific complexity level (1–10). */
    private int scientificLevel;

    /** Refined sci-fi category, such as "dystopia", "time travel", or "space opera". */
    private String subGenre;

    /** Unique code for this book, auto-generated during construction. */
    private final String libraryCode;

    /**
     * Generates a unique library code using timestamp + random number + counter.
     * <p>
     * Format: BK-SyyyyMMddHHmmssSSS-<random>-<counter>
     *
     * @return A unique library code string
     */
    private static String generateCode(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);

        int count = counter.getAndIncrement();

        return "Bk-S" + timestamp +"-" + String.format("%03d",randomPart) +"-" +count;
    }

    /**
     * Constructs a new {@code ScienceFictionBook} object.
     *
     * @param title            book title
     * @param author           author name
     * @param pageCount        total number of pages (validated)
     * @param category         high-level category (typically "Science Fiction")
     * @param borrowedDate     borrow date (nullable)
     * @param returnDate       expected return date (nullable)
     * @param scientificLevel  realism/complexity level (1–10)
     * @param subGenre         specific sub-genre tag (non-blank, non-numeric)
     * @throws IllegalArgumentException if any validation fails
     */
    public ScienceFictionBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,int scientificLevel,String subGenre){
        super(title,author,pageCount,category,borrowedDate,returnDate);
        this.scientificLevel = BookUtils.validateLevel1to10(scientificLevel);
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-Genre");
        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }

    /**
     * Updates the sub-genre tag.
     *
     * @param subGenre new label to set (validated)
     * @throws IllegalArgumentException if input is blank or contains digits
     */
    public void setSubGenre(String subGenre){
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-Genre");
    }

    /** @return the sub-genre label for this science fiction book */
    public String getSubGenre(){
        return subGenre;
    }

    /**
     * Updates the scientific complexity level.
     *
     * @param scientificLevel new level to set (must be between 1 and 10)
     * @throws IllegalArgumentException if level is out of bounds
     */
    public void setScientificLevel(int scientificLevel){
        this.scientificLevel = BookUtils.validateLevel1to10(scientificLevel);
    }

    /** @return scientific realism or complexity level (1–10) */
    public int getScientificLevel(){
        return scientificLevel;
    }

    @Override
    public String getLibraryCode() {
        return libraryCode;
    }

    /**
     * Returns a printable string with all book details, including science fiction–specific fields.
     *
     * @return formatted string containing complete book information
     */
    @Override
    public String toString(){
        return super.toString() +
                " | Sub-genre: " + subGenre +
                " | Scientific level: " + scientificLevel;
    }
}
