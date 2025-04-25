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
        for(Book book : manager.getCatalog()){
            if(book.getLibraryCode().equalsIgnoreCase(libraryCode)){
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

}
