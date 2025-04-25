package com.murat.library;

import com.murat.library.utils.LibraryUtils;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args){
        LibraryManager manager = new LibraryManager();
        Book b1 = new Book("12","deneme","murat",23,"horor",
                LocalDate.of(2023,4,5),LocalDate.now());
        Book b2 = new Book("13","deneme1","murat",23,"horodr",
                LocalDate.of(2023,4,5),LocalDate.now());
        Book b3 = new Book("14","deneme2","murat",23,"hororf",
                LocalDate.of(2023,4,5),LocalDate.now());
        manager .addBook(b1);
        manager.addBook(b2);
        manager.addBook(b3);
        LibraryManager manager1 = new LibraryManager();
        LibraryUtils.filterByCategory(manager1,"horor");
    }
}
