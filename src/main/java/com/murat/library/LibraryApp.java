package com.murat.library;

import com.murat.library.genres.DetectiveBook;
import com.murat.library.genres.FantasyBook;
import com.murat.library.genres.HorrorBook;
import com.murat.library.genres.ScienceFictionBook;
import com.murat.library.utils.LibraryUtils;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args){
    LibraryManager manager = new LibraryManager();
        FantasyBook b1 = new FantasyBook("fantasy","murat",456,"Fantasy",
                LocalDate.of(2025,3,12),LocalDate.now(),"zombie",6);
        manager.addBook(b1);
        manager.listBooks();


    }
}
