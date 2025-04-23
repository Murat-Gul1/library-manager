package com.murat.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of books in the library.
 * Provides basic operations such as add, remove, find, and list.
 */
public class LibraryManager {

    private List<Book> catalog;

    /**
     * Initializes an empty library catalog.
     */
    public LibraryManager() {
        this.catalog = new ArrayList<>();
    }

    /**
     * Adds a book to the catalog.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        catalog.add(book);
    }

    /**
     * Removes a book from the catalog by its library code.
     *
     * @param libraryCode the unique code of the book
     * @return true if a book was removed, false otherwise
     */
    public boolean removeBook(String libraryCode) {
        return catalog.removeIf(book -> book.getLibraryCode().equalsIgnoreCase(libraryCode));
    }

    /**
     * Finds a book by its title.
     *
     * @param title the title to search
     * @return the first matching book, or null if not found
     */
    public Book findBookByTitle(String title) {
        return catalog.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    /**
     * Prints all books in the catalog to the console.
     */
    public void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books found.");
        } else {
            catalog.forEach(System.out::println);
        }
    }

    /**
     * Returns the internal book list for further processing.
     *
     * @return the book catalog
     */
    public List<Book> getCatalog() {
        return catalog;
    }
}
