package com.murat.library;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Represents a book in the library system.
 * Each book has a unique library code and contains metadata such as title, author,
 * page count, category, and loan-related information.
 */
public class Book {
    private  String libraryCode;
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
     * @param title Title of the book.
     * @param author Author of the book.
     * @param pageCount Total number of pages.
     * @param category Category of the book.
     * @param borrowedDate The date the book was borrowed.
     * @param returnDate The date the book should be returned.
     */
    public Book( String title, String author, int pageCount
    ,String category, LocalDate borrowedDate, LocalDate returnDate){
        this.title = BookUtils.validateBasicText(title, "Title");
        this.author = BookUtils.validateNameText(author,"Author");
        this.pageCount = BookUtils.validatePageCount(pageCount);
        this.category = BookUtils.validateNameText(category,"Category");
        setBorrowedDate(borrowedDate);
        setReturnDate(returnDate);
    }

    public String getLibraryCode(){
        return libraryCode;
    }
    protected void setLibraryCode(String libraryCode){
        this.libraryCode = libraryCode;
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
        try {
            if (borrowedDate == null) {
                this.borrowedDate = null;
                return;
            }
            
            if (borrowedDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Borrowed date cannot be in the future");
            }
            
            this.borrowedDate = borrowedDate;
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error setting borrowed date: " + e.getMessage());
            throw e;
        }
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
        return  "Library Code: " + libraryCode + "|" +
                " Title: " + title + "|" +
                " Author: " + author + "|" +
                " Page Count: " + pageCount + "|" +
                " Category: " + category + "|" +
                " Borrowed: " + borrowedDate + "|" +
                " Return by: " + returnDate;

    }
}
