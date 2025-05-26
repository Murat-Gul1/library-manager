package com.murat.library;
import com.murat.library.genres.*;
import java.time.LocalDate;
import java.util.Scanner;
import com.murat.library.utils.LibraryUtils;
public class LibraryApp {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    LibraryManager manager = new LibraryManager();
    boolean exit = false;
    initializeSampleBooks(manager);
    System.out.println("Welcome to the Library Management System");
    
    while(!exit){
        System.out.println("\n----- LIBRARY MANAGEMENT SYSTEM -----");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. List all books");
        System.out.println("4. Find book by library code");
        System.out.println("5. Filter books by category");
        System.out.println("6. Filter books by author");
        System.out.println("7. Advanced search");
        System.out.println("8. Update book");
        System.out.println("9. Save books to file");
        System.out.println("10. Load books from file");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1:
                addBook(scanner,manager);
                break;
            case 2:
                removeBook(scanner,manager);
                break;
            case 3:
                manager.listBooks();
                break;
            case 4:
                findBookByLibraryCode(scanner,manager);
                break;
            case 5:
                filterBooksByCategory(scanner,manager);
                break;
            case 6:
                filterBooksByAuthor(scanner,manager);
                break;
            case 7:
                advancedSearch(scanner,manager);
                break;
            case 8:
                updateBook(scanner,manager);
                break;
            case 9:
                saveBooksToFile(scanner,manager);
                break;
            case 10:
                loadBooksFromFile(scanner,manager);
                break;
            case 0:
                exit = true;
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    scanner.close();
    }




    /**
     * Initializes the library with a set of sample books across different genres.
     * This method is typically called at application startup to populate the library
     * with example books for demonstration and testing purposes.
     *
     * The sample books include:
     * <ul>
     *   <li>A biography of Steve Jobs by Walter Isaacson</li>
     *   <li>A science fiction book "A Brief History of Time" by Stephen Hawking</li>
     *   <li>A historical book "Guns, Germs, and Steel" by Jared Diamond</li>
     * </ul>
     *
     * @param manager The LibraryManager instance where the sample books will be added.
     *               Must not be null.
     *
     * @throws NullPointerException if the provided manager is null
     *
     * @see BiographyBook
     * @see ScienceFictionBook
     * @see HistoricalBook
     */
    public static void initializeSampleBooks(LibraryManager manager){
        BiographyBook biographyBook = new BiographyBook("Steve Jobs","Walter Isaacson",650
        ,"Biography",LocalDate.of(2025,5,15),LocalDate.of(2025,6,15),"Steve Jobs",1955,2011);
        manager.addBook(biographyBook);

        ScienceFictionBook scienceFictionBook = new ScienceFictionBook("A Brief History of Time","Stephen Hawking"
        ,256,"Science Fiction",LocalDate.of(2025,5,15),LocalDate.of(2025,6,15),8,"Time");
        manager.addBook(scienceFictionBook);
        
        HistoricalBook historicalBook = new HistoricalBook("Guns, Germs, and Steel: The Fates of Human Societies"," Diamond"
        ,480,"History",LocalDate.of(2025,5,15),LocalDate.of(2025,6,15),"11000 BCE","Global");
        manager.addBook(historicalBook);
    }
    /**
     * Adds a new book to the library based on user input.
     *
     * This method presents a menu of book types to the user and collects
     * the necessary information to create and add a new book to the library.
     * The method handles seven different book types, each with its own
     * specific set of attributes.
     *
     * <p>Book types:
     * <ol>
     *   <li>Biography - Requires subject name, birth year, and death year</li>
     *   <li>Detective - Requires mystery level and sub-genre</li>
     *   <li>Fantasy - Requires sub-genre and fantasy level</li>
     *   <li>Historical - Requires era start year and region</li>
     *   <li>Horror - Requires sub-genre and horror level</li>
     *   <li>Science Fiction - Requires sub-genre and sci-fi level</li>
     *   <li>Romance - Requires sub-genre and romance level</li>
     * </ol>
     *
     * All book types require the following common attributes:
     * <ul>
     *   <li>Title</li>
     *   <li>Author name</li>
     *   <li>Page count</li>
     *   <li>Borrowed date (in yyyy-MM-dd format)</li>
     *   <li>Return date (in yyyy-MM-dd format)</li>
     * </ul>
     *
     * @param scanner The Scanner object used to read user input
     * @param manager The LibraryManager instance where the new book will be added
     *
     * @see BiographyBook
     * @see DetectiveBook
     * @see FantasyBook
     * @see HistoricalBook
     * @see HorrorBook
     * @see ScienceFictionBook
     * @see RomanceBook
     */
    public static void addBook(Scanner scanner, LibraryManager manager){
        System.out.println("Enter the book type" +
        "1-Biography" +
        "2-Detective" +
        "3-Fantasy" +
        "4-Historical" +
        "5-Horor" +
        "6-Science Fiction" +
        "7-Romance");
        int bookType = scanner.nextInt();
        scanner.nextLine();
        String title;
        String author;
        int pageCount;
        LocalDate borrowedDate;
        LocalDate returnDate;
        String subGenre;
        switch(bookType){
            case 1:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the subject name");
                String subjectName = scanner.nextLine();
                System.out.println("Enter the birth year");
                int birthYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the death year");
                int deathYear = scanner.nextInt();
                scanner.nextLine();
                BiographyBook biographyBook = new BiographyBook(title, author, pageCount, "Biography", borrowedDate, returnDate, subjectName, birthYear, deathYear);
                manager.addBook(biographyBook);
               break;
            case 2:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the mystery level");
                int mysteryLevel = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the sub genre");
                subGenre = scanner.nextLine();
                DetectiveBook detectiveBook = new DetectiveBook(title, author, pageCount, "Detective", borrowedDate, returnDate, mysteryLevel, subGenre);
                manager.addBook(detectiveBook);
                break;
            case 3:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the sub genre");
                subGenre = scanner.nextLine();
                System.out.println("Enter the fantasy level");
                int fantasyLevel = scanner.nextInt();
                scanner.nextLine();
                FantasyBook fantasyBook = new FantasyBook(title, author, pageCount, "Fantasy", borrowedDate, returnDate, subGenre, fantasyLevel);
                manager.addBook(fantasyBook);
                break;
            case 4:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the era start year");
                String eraStartYear = scanner.nextLine();
                System.out.println("Enter the region");
                String region = scanner.nextLine();
                HistoricalBook historicalBook = new HistoricalBook(title, author, pageCount, "Historical", borrowedDate, returnDate, eraStartYear, region);
                manager.addBook(historicalBook);
                break;
            case 5:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the sub genre");
                subGenre = scanner.nextLine();
                System.out.println("Enter the horror level");
                int horrorLevel = scanner.nextInt();
                scanner.nextLine();
                HorrorBook horrorBook = new HorrorBook(title, author, pageCount, "Horror", borrowedDate, returnDate, subGenre, horrorLevel);
                manager.addBook(horrorBook);
                break;
            case 6:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the sub genre");
                subGenre = scanner.nextLine();
                System.out.println("Enter the science fiction level");
                int scienceFictionLevel = scanner.nextInt();
                scanner.nextLine();
                ScienceFictionBook scienceFictionBook = new ScienceFictionBook(title, author, pageCount, "Science Fiction", borrowedDate, returnDate, scienceFictionLevel, subGenre);
                manager.addBook(scienceFictionBook);
                break;
            case 7:
                System.out.println("Enter the book title");
                title = scanner.nextLine();
                System.out.println("Enter the author name");
                author = scanner.nextLine();
                System.out.println("Enter the page count");
                pageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the borrowed date");
                borrowedDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the return date");
                returnDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the sub genre");
                subGenre = scanner.nextLine();
                System.out.println("Enter the romance level");
                int romanceLevel = scanner.nextInt();
                scanner.nextLine();
                RomanceBook romanceBook = new RomanceBook(title, author, pageCount, "Romance", borrowedDate, returnDate, subGenre ,romanceLevel);
                manager.addBook(romanceBook);
                break;
            default:
                System.out.println("Invalid book type. Please try again.");
                break;     
        }
    }
    /**
     * Removes a book from the library based on its unique library code.
     *
     * This method prompts the user to enter a book code and attempts to remove
     * the corresponding book from the library's catalog. The operation's success
     * or failure is determined by the return value of the manager's removeBook method.
     *
     * @param scanner The Scanner object used to read user input
     * @param manager The LibraryManager instance from which the book will be removed
     *
     * @apiNote The book code comparison is case-insensitive.
     *
     * @example
     * // Example usage:
     * // User enters a code like "BK-B202505241441-123"
     * // Returns true if book was found and removed, false otherwise
     */
    public static void removeBook(Scanner scanner , LibraryManager manager){
        System.out.println("Enter the book code");
        String code = scanner.nextLine();
        manager.removeBook(code);
    }
    /**
     * Searches for a book in the library using its unique library code.
     *
     * This method prompts the user to enter a library code and displays the
     * corresponding book's details if found. The search is performed by the
     * LibraryUtils.findBookByCode() method, which handles the actual search
     * operation and displays the results.
     *
     * @param scanner The Scanner object used to read the library code input
     * @param manager The LibraryManager instance containing the book catalog
     *
     * @see LibraryUtils#findBookByCode(LibraryManager, String)
     *
     * @example
     * // Example usage:
     * // User enters: "BK-B202505241500-456"
     * // Output: Displays book details if found, or "Book not found" message
     */
    public static void findBookByLibraryCode(Scanner scanner , LibraryManager manager){
        System.out.println("Enter the library code to search for:");
        String bookCode = scanner.nextLine();
        LibraryUtils.findBookByCode(manager,bookCode);
    }
    /**
     * Filters and displays books by a specific category.
     *
     * This method prompts the user to enter a book category and displays
     * all books that match the given category. The search is case-insensitive.
     * If no books are found in the specified category, an appropriate message
     * will be displayed.
     *
     * @param scanner The Scanner object used to read the category input
     * @param manager The LibraryManager instance containing the book catalog
     *
     * @see LibraryUtils#filterByCategory(LibraryManager, String)
     *
     * @example
     * // Example usage:
     * // User enters: "Science Fiction"
     * // Output: Displays all books in the Science Fiction category
     */
    public static void filterBooksByCategory(Scanner scanner , LibraryManager manager){
        System.out.println("write the book category");
        String category = scanner.nextLine();
        LibraryUtils.filterByCategory(manager,category);
    }
    /**
 * Filters and displays books written by a specific author.
 *
 * This method prompts the user to enter an author name and displays
 * all books written by that author. The search is case-insensitive.
 * If no books are found by the specified author, an appropriate message
 * will be displayed.
 *
 * @param scanner The Scanner object used to read the author name input
 * @param manager The LibraryManager instance containing the book catalog
 *
 * @see LibraryUtils#filterByAuthor(LibraryManager, String)
 *
 * @example
 * // Example usage:
 * // User enters: "Stephen Hawking"
 * // Output: Displays all books written by Stephen Hawking or "No books found for author" message
 */
    public static void filterBooksByAuthor(Scanner scanner , LibraryManager manager){
        System.out.println("write the author name");
        String author = scanner.nextLine();
        LibraryUtils.filterByAuthor(manager, author);
    }

}

