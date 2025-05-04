package com.murat.library;

import com.murat.library.genres.DetectiveBook;
import com.murat.library.genres.HorrorBook;
import com.murat.library.genres.ScienceFictionBook;
import com.murat.library.utils.LibraryUtils;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args){
    LibraryManager manager = new LibraryManager();
        ScienceFictionBook b1 = new ScienceFictionBook("Space","Murat",567,"Science",
                LocalDate.of(2025,3,12),LocalDate.now(),6,"Mars");
        manager.addBook(b1);
        manager.listBooks();

    }
}
