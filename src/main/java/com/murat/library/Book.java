package com.murat.library;
import com.murat.library.utils.BookUtils;
import java.time.LocalDate;


/**
 * Represents a generic book in the library.
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

    /**
     * Gets the unique library code of the book.
     *
     * @return the library code
     */
    public String getLibraryCode(){
        return libraryCode;
    }

    /**
     * Sets the unique library code of the book.
     *
     * @param libraryCode the library code to set
     */
    protected void setLibraryCode(String libraryCode){
        this.libraryCode = libraryCode;
    }

    /**
     * Gets the title of the book.
     *
     * @return the book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the book title to set
     */
    public void setTitle(String title) {
        this.title = BookUtils.validateBasicText(title , "Title");
    }

     /**
     * Gets the author of the book.
     *
     * @return the author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the author's name to set
     */
    public void setAuthor(String author) {
        this.author = BookUtils.validateNameText(author,"Author");
    }

    /**
     * Gets the number of pages in the book.
     *
     * @return the page count
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the number of pages in the book.
     *
     * @param pageCount the page count to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = BookUtils.validatePageCount(pageCount);
    }

    /**
     * Gets the category of the book.
     *
     * @return the book category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the book.
     *
     * @param category the book category to set
     */
    public void setCategory(String category) {
        this.category = BookUtils.validateNameText(category,"Category");
    }

    /**
     * Gets the date when the book was borrowed.
     *
     * @return the borrowed date, or null if not borrowed
     */
    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    /**
     * Sets the date when the book was borrowed.
     *
     * @param borrowedDate the date to set as the borrowed date
     */
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
        }
    }

    /**
     * Gets the date when the book is expected to be returned.
     *
     * @return the return date, or null if not set
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the date when the book is expected to be returned.
     *
     * @param returnDate the return date to set
     */
    public void setReturnDate(LocalDate returnDate) {
        try{
            if(returnDate == null){
                this.returnDate = null; 
                return;
            }
            if(returnDate.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("Return date cannot be in the past");
            }

            if(this.borrowedDate != null && returnDate.isBefore(this.borrowedDate)){
                throw new IllegalArgumentException("Return date cannot be before borrowed date");
            }
            this.returnDate = returnDate;

        }catch(Exception e){
            System.err.println("Error setting return date: " + e.getMessage());    
        }
    }

    /**
     * Returns a string representation of the book, including its library code, title, author, and category.
     *
     * @return a string describing the book
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
