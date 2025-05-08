package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a romance genre book in the library system.
 * <p>
 * In addition to the standard {@link Book} attributes, this class adds:
 * <ul>
 *   <li>{@code subGenre} – a more specific romance category
 *       (e.g. "historical romance", "contemporary", "paranormal").</li>
 *   <li>{@code romanticLevel} – an integer from <b>1 to 10</b> indicating
 *       how intensely romantic the story is.</li>
 * </ul>
 * Each instance also receives a unique {@code libraryCode} generated
 * via timestamp + random + counter pattern.
 */
public class RomanceBook extends Book {
    /** Counter for generating unique library codes in this subclass. */
    private static final AtomicInteger counter = new AtomicInteger();

    /** Random component to reduce collision risk in library codes. */
    private static final Random random = new Random();

    /** Refined romance category (no digits, not blank). */
    private String subGenre;

    /** Romantic intensity on a 1–10 scale (inclusive). */
    private int romanticLevel;

    /** System-generated unique code, set at construction time. */
    private final String libraryCode;

    /**
     * Generates a unique library code for a romance book.
     * <p>
     * Format: BK-RyyyyMMddHHmmssSSS-<random>-<counter>
     *
     * @return a unique identifier string
     */
    private static String generateCode(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);

        int count = counter.getAndIncrement();

        return "Bk-R" + timestamp +"-" + String.format("%03d",randomPart) +"-" +count;
    }

    /**
     * Constructs a new {@code RomanceBook}.
     *
     * @param title          the book’s title
     * @param author         the author’s name
     * @param pageCount      total pages (validated in {@link Book})
     * @param category       high-level category (typically "Romance")
     * @param borrowedDate   date borrowed (nullable)
     * @param returnDate     due date for return (nullable)
     * @param subGenre       specific romance type (validated text)
     * @param romanticLevel  romantic intensity (1–10, validated)
     * @throws IllegalArgumentException if any validation fails
     */
    public RomanceBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,String subGenre,int romanticLevel){
        super(title,author,pageCount,category,borrowedDate,returnDate);
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-Genre");
        this.romanticLevel = BookUtils.validateLevel1to10(romanticLevel);
        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }

    /**
     * Updates the refined romance category.
     *
     * @param subGenre new category label (no digits, not blank)
     * @throws IllegalArgumentException if validation fails
     */
    public void setSubGenre(String subGenre){
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-Genre");
    }

    /** @return the refined romance category */
    public String getSubGenre(){
        return subGenre;
    }

    /**
     * Updates the romantic intensity level.
     *
     * @param romanticLevel new level 1–10
     * @throws IllegalArgumentException if out of range
     */
    public void setRomanticLevel(int romanticLevel){
        this.romanticLevel = BookUtils.validateLevel1to10(romanticLevel);
    }

    /** @return the romantic intensity level (1–10) */
    public int getRomanticLevel(){
        return romanticLevel;
    }

    /**
     * Returns the system-generated library code for this book.
     * @return unique libraryCode string
     */
    @Override
    public String getLibraryCode() {
        return libraryCode;
    }

    /**
     * Returns a formatted string containing all book details,
     * including romance-specific fields.
     *
     * @return descriptive book information
     */
    @Override
    public  String toString(){
        return   super.toString() +
                " | Sub-genre: " + subGenre +
                " | Romantic Level: " + romanticLevel;
    }
}
