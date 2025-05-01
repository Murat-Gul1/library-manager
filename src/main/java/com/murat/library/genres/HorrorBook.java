package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;

/**
 * A concrete {@link Book} representing works in the horror genre.
 * <p>
 * Besides the common book fields, it adds:
 * <ul>
 *     <li>{@code subGenre} – a textual tag that refines the horror type
 *         (e.g. “haunted-house”, “slasher”, “cosmic horror”).</li>
 *     <li>{@code scareLevel} – an integer from <b>1 to 10</b> indicating how frightening the story is
 *         (10 = extremely scary).</li>
 * </ul>
 * All extra data is validated through {@link BookUtils}.
 */

public class HorrorBook extends Book {
    /** Refines the horror type, e.g. “zombie outbreak”, “psychological”. */
    private String subGenre;

    /** Fright factor; must stay between 1 and 10 (inclusive). */
    private int scareLevel;


    /**
     * Creates a {@code HorrorBook} with horror-specific attributes.
     *
     * @param title         title of the book
     * @param author        author name
     * @param pageCount     total pages (validated 1–10 000)
     * @param category      high-level category (usually “Horror”)
     * @param borrowedDate  borrow date (nullable)
     * @param returnDate    expected return date (nullable)
     * @param subGenre      more specific horror tag (no digits, not blank)
     * @param scareLevel    fear rating 1–10
     * @throws IllegalArgumentException if any validation fails
     */
    public HorrorBook( String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate,String subGenre,int scareLevel){
        super(title,author,pageCount,category,borrowedDate,returnDate);
            this.subGenre = BookUtils.validateNameText(subGenre, "Sub Genre");
            this.scareLevel = BookUtils.validateLevel1to10(scareLevel);
    }
    /* ---------- accessors ---------- */
    public void setSubGenre(String subGenre){
            this.subGenre = BookUtils.validateNameText(subGenre,"Sub-Genre");
    }
    public String getSubGenre(){
        return subGenre;
    }
    public void setScareLevel(int scareLevel){
            this.scareLevel = BookUtils.validateLevel1to10(scareLevel);
    }
    public int getScareLevel(){
        return scareLevel;
    }

    @Override
    public  String toString(){
       return super.toString() +
               " | Sub-genre: " + subGenre +
               " | Scare Level: " + scareLevel;
    }
}

