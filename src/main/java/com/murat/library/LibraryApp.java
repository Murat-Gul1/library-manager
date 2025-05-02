package com.murat.library;

import com.murat.library.genres.DetectiveBook;
import com.murat.library.genres.HorrorBook;
import com.murat.library.utils.LibraryUtils;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args){
    LibraryManager manager = new LibraryManager();
    HorrorBook b1 = new HorrorBook("doul","murat",56,"Horor",
    LocalDate.of(2021,2,4),LocalDate.now(),"Killer",6);
        HorrorBook b2 = new HorrorBook("doul2","murat",58,"Horor",
                LocalDate.of(2021,2,4),LocalDate.now(),"Killer",6);
    manager.addBook(b1);
        manager.addBook(b2);
    DetectiveBook d1 = new DetectiveBook("crayz","murat",678,"Detective"
    ,LocalDate.of(2024,5,6),LocalDate.now(),7,"soul");
        DetectiveBook d2 = new DetectiveBook("crayz2","murat",679,"Detective"
                ,LocalDate.of(2024,5,6),LocalDate.now(),7,"soul");
    manager.addBook(d1);
        manager.addBook(d2);
    manager.listBooks();
    }
}
