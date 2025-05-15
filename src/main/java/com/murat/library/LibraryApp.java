package com.murat.library;
import com.murat.library.genres.*;
import java.time.LocalDate;
import java.util.Scanner;
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
                findBookByLibraryCodeM(scanner,manager);
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

}

