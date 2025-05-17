package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * <p><b>DetectiveBook</b> models fiction that revolves around a mystery, crime,
 * or investigative plot‑line.</p>
 *
 * <p>Besides the common {@link Book} fields, it adds:</p>
 * <ul>
 *     <li>{@code subGenre} &nbsp;– a textual tag that refines the detective style
 *         (e.g.&nbsp;“police‑procedural”, “cosy mystery”, “noir”).</li>
 *     <li>{@code mysteryLevel} – an integer from <strong>1&nbsp;to&nbsp;10</strong>
 *         indicating how complex or puzzling the case is (10 = fiendishly intricate).</li>
 * </ul>
 *
 * <p>Both extra attributes are rigorously validated through {@link BookUtils}:</p>
 * <ul>
 *     <li>{@code subGenre} must be non‑blank text that contains no digits.</li>
 *     <li>{@code mysteryLevel} must fall within the inclusive range 1‑10.</li>
 * </ul>
 */

public class DetectiveBook extends Book {
    private static final AtomicInteger counter = new AtomicInteger();
    private static final Random random = new Random();

    /** Puzzle complexity on a 1 - 10 scale(10 = extremely intricate). */
    private int mysteryLevel;


    /** A finer detective category such as “cosy”, “forensic”, “hard‑boiled”. */
    private String subGenre;

    /** Immutable, system‑generated identifier that uniquely distinguishes every book instance. */
    private final String libraryCode;

    /**
     * Generates a unique library code for detective books.
     * Format: BK-DyyyyMMddHHmmssSSS-<random>-<counter>
     *
     * Components:
     * - Prefix "BK-D" identifies the book as a detective genre.
     * - Timestamp: current date and time down to milliseconds (e.g., 20240503161530123).
     * - Random Part: 3-digit random number (000–999) to reduce risk of collision.
     * - Counter: sequential number that increments with each code generation.
     *
     * Example output: BK-D20240503161530123-027-42
     */
    private static String generateCode(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);
        int count = counter.getAndIncrement();
        return "BK-D" + timestamp+"-"+String.format("%03d",randomPart)+"-"+count;
    }


    /**
     * Constructs a {@code DetectiveBook}.
     *
     * @param title         title of the book
     * @param author        author name
     * @param pageCount     total pages (validated in {@link Book})
     * @param category      high‑level category label (usually “Detective”)
     * @param borrowedDate  borrow date (nullable)
     * @param returnDate    expected return date (nullable)
     * @param mysteryLevel  case complexity 1‑10 (inclusive)
     * @param subGenre      detective sub‑genre label (no digits, not blank)
     * @throws IllegalArgumentException if any validation fails
     */
    public DetectiveBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,int mysteryLevel,String subGenre){
        super(title,author,pageCount,category,borrowedDate,returnDate);
        this.mysteryLevel = BookUtils.validateLevel1to10(mysteryLevel);
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-genre");
        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }


    /**
     * Updates the mystery complexity level.
     *
     * @param mysteryLevel value 1‑10
     * @throws IllegalArgumentException if out of range
     */
    public void setMysteryLevel(int mysteryLevel){
        this.mysteryLevel = BookUtils.validateLevel1to10(mysteryLevel);
    }


    /** @return puzzle complexity (1‑10) */
    public int getMysteryLevel(){
        return mysteryLevel;
    }

    /**
     * Updates the detective sub‑genre.
     *
     * @param subGenre new label (validated text)
     * @throws IllegalArgumentException if validation fails
     */
    public void setSubGenre(String subGenre){
        this.subGenre = BookUtils.validateNameText(subGenre,"Sub-genre");
    }


    /** @return detective sub‑genre label */
    public String getSubGenre(){
        return subGenre;
    }

    @Override
    public String getLibraryCode() {
        return libraryCode;
    }

    /** Adds detective‑specific details to the base {@link Book#toString()}. */
    @Override
    public String toString(){
       return super.toString() +
       " | Sub-genre: " + subGenre +
       " | Mystery level: " + mysteryLevel;
    }
}
