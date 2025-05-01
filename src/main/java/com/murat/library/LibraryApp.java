package com.murat.library;

import com.murat.library.genres.HorrorBook;
import com.murat.library.utils.LibraryUtils;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args){
        LibraryManager manager = new LibraryManager();
    HorrorBook h1 = new HorrorBook("Scary","Murat",62,"Horor",LocalDate.of(2025,4,12),LocalDate.now(),
            "psychological",4);
        HorrorBook h2 = new HorrorBook("extremely scary","Murat",23,"Horor",LocalDate.of(2025,4,12),LocalDate.now(),
                "Zombie",4);
    manager.addBook(h1);
    manager.addBook(h2);
    manager.listBooks();

    }
}
