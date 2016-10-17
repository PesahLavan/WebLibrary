package com.pesahlavan.weblibrary.interfaces;


import com.pesahlavan.weblibrary.objects.Book;

public interface ShowBook {

    void showBook(Book book);
    void downloadBook(Book book);
    void voteBook(Book book);

}
