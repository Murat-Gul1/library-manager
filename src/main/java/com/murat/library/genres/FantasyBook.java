package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a fantasy genre book in the library system.
 * <p>
 * In addition to standard {@link Book} fields, this class includes:
 * <ul>
 *     <li>{@code subGenre} – specific type of fantasy, such as "epic", "dark", or "urban fantasy".</li>
 *     <li>{@code fantasyLevel} – an integer from <b>1 to 10</b> that represents how magical or fantastical the story is.</li>
 * </ul>
 * A unique {@code libraryCode} is generated for each instance using timestamp + random + counter.
 */

public class FantasyBook extends Book{
    private static final AtomicInteger counter = new AtomicInteger();
    private static final Random random = new Random();

    /** Refined fantasy category, e.g. "epic", "urban", "dark". */
    private String subGenre;

    /** Indicates magical intensity or fantasy depth (1–10). */
    private int fantasyLevel;

    /** Unique code for this book, automatically generated. */
    private final String libraryCode;

    /**
     * Generates a unique library code using the current timestamp, a random number, and a sequential counter.
     * Format: BK-FyyyyMMddHHmmssSSS-<random>-<counter>
     *
     * @return a unique string for identifying this fantasy book
     */
    private static String generateCode(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);

        int count = counter.getAndIncrement();

        return "Bk-F" + timestamp +"-" + String.format("%03d",randomPart) +"-" +count;
    }

    /**
     * Constructs a new {@code FantasyBook} with all required fields and fantasy-specific properties.
     *
     * @param title         book title
     * @param author        author name
     * @param pageCount     total number of pages (validated)
     * @param category      general category (e.g. "Fantasy")
     * @param borrowedDate  borrow date (nullable)
     * @param returnDate    return due date (nullable)
     * @param subGenre      refined fantasy label (no digits, not blank)
     * @param fantasyLevel  intensity level of fantasy (1–10)
     * @throws IllegalArgumentException if validation fails
     */
    public FantasyBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,String subGenre,int fantasyLevel){
        super(title,author,pageCount,category,borrowedDate,returnDate);
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-genre");
        this.fantasyLevel = BookUtils.validateLevel1to10(fantasyLevel);
        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }

    /**
     * Updates the sub-genre of the fantasy book.
     *
     * @param subGenre new sub-genre label (validated)
     */
    public void setSubGenre(String subGenre){
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-genre");
    }
    /** @return the fantasy sub-genre */
    public String getSubGenre(){
        return subGenre;
    }

    /**
     * Updates the fantasy intensity level.
     *
     * @param fantasyLevel new value between 1 and 10
     * @throws IllegalArgumentException if value is out of bounds
     */
    public void setFantasyLevel(int fantasyLevel){
        this.fantasyLevel = BookUtils.validateLevel1to10(fantasyLevel);
    }

    /** @return the fantasy level value */
    public int getFantasyLevel(){
        return fantasyLevel;
    }

    @Override
    public String getLibraryCode() {
        return libraryCode;
    }

    /**
     * Returns a string including both base and fantasy-specific book details.
     *
     * @return formatted string with full book information
     */
    @Override
    public String toString(){
        return   super.toString() +
                " | Sub-genre: " + subGenre +
                " | Fantasy Level: " + fantasyLevel;
    }
}
