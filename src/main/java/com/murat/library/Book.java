package com.murat.library;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
/**
 * Represents a book in the library system.
 * Each book has a unique library code and contains metadata such as title, author,
 * page count, category, and loan-related information.
 */
public class Book {
    /** Unique identifier of the book in the library system. */
    private String libraryCode;
    /** Title of the book. */
    private String title;
    /** Author of the book. */
    private String author;
    /** Total number of pages in the book. */
    private int pageCount;
    /** Book category (e.g. Fiction, Science, History). */
    private String category;
    /** The date the book was borrowed. */
    private LocalDate borrowedDate;
    /** The due date for returning the book. */
    private LocalDate returnDate;


    /**
     * Constructs a Book object with all required fields.
     * @param libraryCode Unique code assigned to this book.
     * @param title Title of the book.
     * @param author Author of the book.
     * @param pageCount Total number of pages.
     * @param category Category of the book.
     * @param borrowedDate The date the book was borrowed.
     * @param returnDate The date the book should be returned.
     */
    public Book(String libraryCode, String title, String author, int pageCount
    ,String category, LocalDate borrowedDate, LocalDate returnDate){
        this.libraryCode = BookUtils.validateBasicText(libraryCode,"Library Code");
        this.title = BookUtils.validateBasicText(title, "Title");
        this.author = BookUtils.validateNameText(author,"Author");
        this.pageCount = BookUtils.validatePageCount(pageCount);
        this.category = BookUtils.validateNameText(category,"Category");
        setBorrowedDate(borrowedDate);
        setReturnDate(returnDate);
    }

    public void setLibraryCode(String libraryCode){
        this.libraryCode = BookUtils.validateBasicText(libraryCode,"Library Code");
    }

    public String getLibraryCode(){
        return libraryCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = BookUtils.validateBasicText(title , "Title");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = BookUtils.validateNameText(author,"Author");
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = BookUtils.validatePageCount(pageCount);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = BookUtils.validateNameText(category,"Category");
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Returns a formatted string containing all book details.
     * This method is useful for displaying book information in the console.
     * @return Formatted book details as a String.
     */
    @Override
    public String toString(){
        return  "Library Code :" + libraryCode + "|"+
                " Title: " + title + "|" +
                " Author: " + author + "|" +
                " Page Count: " + pageCount + "|" +
                " Category: " + category + "|" +
                " Borrowed: " + borrowedDate + "|" +
                " Return by: " + returnDate;

    }
}
