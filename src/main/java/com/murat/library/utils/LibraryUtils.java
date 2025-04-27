package com.murat.library.utils;
import com.murat.library.Book;
import com.murat.library.LibraryManager;
/**
 * Utility class for library-related helper methods.
 * Contains reusable static methods for interacting with the LibraryManager.
 */
public class LibraryUtils {

    private LibraryUtils(){

    }
    /**
     * Searches the library catalog for a book with the specified library code.
     * <p>
     * If a matching book is found, its details are printed to the console.
     * If not found, a message indicating this is printed.
     *
     * @param manager     the LibraryManager instance containing the book catalog
     * @param libraryCode the code of the book to search for (case-insensitive)
     */
    public static void findBookByCode(LibraryManager manager,String libraryCode){
        libraryCode = BookUtils.validateBasicText(libraryCode,"Library Code");
        for(Book book : manager.getCatalog()){
            if(book.getLibraryCode().equals(libraryCode)){
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");

    }

    /**
     * Filters the book catalog by category and prints matching books to the console.
     * <p>
     * If at least one book in the specified category is found, the book details are printed.
     * Otherwise, a message is displayed indicating that no books were found.
     *
     * @param manager  the LibraryManager instance that holds the catalog of books
     * @param category the category to filter books by (case-insensitive)
     */
    public static void filterByCategory(LibraryManager manager , String category){
        category = BookUtils.validateNameText(category,"Category");
        boolean anyMatch = false;
        for(Book book : manager.getCatalog()){
            if(book.getCategory().equalsIgnoreCase(category)){
                if (!anyMatch) {
                    anyMatch = true;
                }
                System.out.println(book);
            }
        }
        if(!anyMatch){
            System.out.println("No books found in category '" + category + "'.");
        }
    }
    /**
     * Filters the catalog by author name and prints matching books.
     * If no books are found, a message is displayed.
     *
     * @param manager the LibraryManager instance containing the book catalog
     * @param author  the author's name to filter by (case-insensitive)
     */
    public static void filterByAuthor(LibraryManager manager , String author){
        author = BookUtils.validateNameText(author,"Author");
        boolean anyMatch = false;
        for(Book book : manager.getCatalog()){
            if (book.getAuthor().equalsIgnoreCase( author )){
                if(!anyMatch){
                    System.out.println("Books by author '" + author + "':");
                    anyMatch = true;
                }
                System.out.println(book);
            }
        }
        if(!anyMatch){
            System.out.println("No books found for author '" + author + '.');
        }
    }

    /**
     * Searches for books by author, category, and maximum page count.
     * All criteria must be satisfied to include a book in the result.
     * Prints matching books or a message if none found.
     *
     * @param manager      the LibraryManager instance
     * @param author       the author's name to match (case-insensitive)
     * @param category     the category to match (case-insensitive)
     * @param maxPageCount the maximum allowed page count
     */
    public static void advancedSearch(LibraryManager manager, String author, String category, int maxPageCount){
        author = BookUtils.validateNameText(author,"Author");
        category = BookUtils.validateNameText(category,"Category");
        BookUtils.validatePageCount(maxPageCount);
        boolean anyMatch = false;
        for(Book book : manager.getCatalog()){
            boolean authorMatch = book.getAuthor().equalsIgnoreCase(author);
            boolean categoryMatch = book.getCategory().equalsIgnoreCase(category);
            boolean pageMatch = book.getPageCount() <= maxPageCount;
            if(authorMatch && categoryMatch && pageMatch ){
                if(!anyMatch){
                    System.out.println("Matching books:");
                    anyMatch = true;
                }
                System.out.println(book);
            }
        }
        if(!anyMatch){
            System.out.println("No books matched the given criteria.");
        }
    }

}
