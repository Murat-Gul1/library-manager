package com.murat.library.genres;
import com.murat.library.Book;
import com.murat.library.utils.AuthorUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import com.murat.library.utils.BookUtils;

/**
 * Represents a biography or memoir in the library system.
 * <p>
 * Extends {@link Book} with subject-specific life details:
 * <ul>
 *   <li>{@code subjectName} – the person whose life story is told</li>
 *   <li>{@code birthYear} – the subject’s year of birth (validated via {@link AuthorUtils})</li>
 *   <li>{@code deathYear} – the subject’s year of death (validated via {@link AuthorUtils})</li>
 * </ul>
 * Also generates a unique {@code libraryCode} per instance using a timestamp, random number, and counter.
 */
public class BiographyBook extends Book {

    /** Counter to ensure uniqueness in generated library codes. */
    private final static AtomicInteger counter = new AtomicInteger();

    /** Random component for library code generation. */
    private final static Random random = new Random();

    /**
     * Generates a unique library code for biographies.
     * <p>
     * Format: BK-ByyyyMMddHHmmssSSS-<random>-<counter>
     *
     * @return a unique code string
     */

    private static String generateCode() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSSS"));

        int randomPart = random.nextInt(1000);

        int count = counter.getAndIncrement();

        return "BK-B" + timestamp + "-" + String.format("%03d", randomPart) + "-" + count;
    }

    /** The name of the biography’s subject (no digits, not blank). */
    private String subjectName;

    /** The birth year of the subject (1000 ≤ year ≤ current year). */
    private int birthYear;

    /** The death year of the subject (birthYear ≤ year ≤ current year). */
    private int deathYear;

    /** System-generated unique library code for this book. */
    private final String libraryCode;

    /**
     * Constructs a new {@code BiographyBook}.
     *
     * @param title        the book’s title
     * @param author       the author’s name
     * @param pageCount    total pages (validated in {@link Book})
     * @param category     general category label (typically "Biography")
     * @param borrowedDate date the book was borrowed (nullable)
     * @param returnDate   expected return date (nullable)
     * @param subjectName  name of the biography’s subject (validated non-blank text)
     * @param birthYear    subject’s birth year (validated via {@link AuthorUtils})
     * @param deathYear    subject’s death year (validated via {@link AuthorUtils})
     * @throws IllegalArgumentException if any validation fails
     */
    public BiographyBook(String title, String author, int pageCount
            , String category, LocalDate borrowedDate, LocalDate returnDate, String subjectName
            , int birthYear, int deathYear) {
        super(title, author, pageCount, category, borrowedDate, returnDate);
        this.subjectName = BookUtils.validateNameText(subjectName, "Subject Name");
        this.birthYear = AuthorUtils.validateBirthYear(birthYear);
        this.deathYear = AuthorUtils.validateDeathYear(birthYear, deathYear);

        this.libraryCode = generateCode();
        super.setLibraryCode(libraryCode);
    }

    /**
     * Updates the biography subject’s name.
     *
     * @param subjectName new name (no digits, not blank)
     * @throws IllegalArgumentException if validation fails
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = BookUtils.validateNameText(subjectName, "Subject Name");
    }

    /** @return the biography subject’s name */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Updates the birth year of the subject.
     *
     * @param birthYear new birth year (1000 ≤ year ≤ current year)
     * @throws IllegalArgumentException if validation fails
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = AuthorUtils.validateBirthYear(birthYear);
    }

    /** @return the subject’s birth year */
    public int getBirthYear() {
        return birthYear;
    }


    /**
     * Updates the death year of the subject.
     *
     * @param deathYear new death year (birthYear ≤ year ≤ current year)
     * @throws IllegalArgumentException if validation fails
     */
    public void setDeathYear(int deathYear) {
        this.deathYear = AuthorUtils.validateDeathYear(birthYear, deathYear);
    }

    /** @return the subject’s death year */
    public int getDeathYear() {
        return deathYear;
    }

    /**
     * Retrieves the system-generated library code for this biography.
     *
     * @return unique library code string
     */
    @Override
    public String getLibraryCode() {
        return libraryCode;
    }

    /**
     * Returns a detailed string with both base and biography-specific book information.
     *
     * @return formatted book details
     */
    @Override
    public String toString() {
        String deathYearStr;
        if(deathYear == -1){
            deathYearStr = "Still alive";
        }else if(deathYear == 0){
            deathYearStr = "No information available";
        }else{
            deathYearStr = String.valueOf(deathYear);
        }
        return super.toString() +
                " | Subject Name: " + subjectName +
                " | Subject Birth Year: " + birthYear +
                " | Subject Death Year: " + deathYearStr;
    }
}



