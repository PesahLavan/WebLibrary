package com.pesahlavan.weblibrary.interfaces;


import com.pesahlavan.weblibrary.objects.Author;
import com.pesahlavan.weblibrary.objects.Book;
import com.pesahlavan.weblibrary.objects.Genre;

import java.util.List;

public interface BookSearch {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

}
