package com.murat.library;
import com.murat.library.genres.*;
import java.time.LocalDate;
import java.util.Scanner;
public class LibraryApp {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    LibraryManager manager = new LibraryManager();
    boolean exit = false;
    
    

    }

    public static void initializeSampleBooks(LibraryManager manager){
        BiographyBook biographyBook = new BiographyBook("Steve Jobs","Walter Isaacson",650
        ,"Biography",LocalDate.of(2025,5,15),LocalDate.of(2025,6,15),"Steve Jobs",1955,2011);
        manager.addBook(biographyBook);

        
    }
}
