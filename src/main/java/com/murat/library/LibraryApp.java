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
    public static void removeBook(Scanner scanner , LibraryManager manager){
        System.out.println("Enter the book code");
        String code = scanner.nextLine();
        manager.removeBook(code);
    }
    public static void findBookByLibraryCode(Scanner scanner , LibraryManager manager){
        System.out.println("Enter the library code to search for:");
        String bookCode = scanner.nextLine();
        LibraryUtils.findBookByCode(manager,bookCode);
    }

}

