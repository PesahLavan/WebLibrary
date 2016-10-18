package com.pesahlavan.weblibrary.dao.interfaces;


import com.pesahlavan.weblibrary.entities.Author;
import com.pesahlavan.weblibrary.entities.Book;
import com.pesahlavan.weblibrary.entities.Genre;

import java.util.List;


public interface BookDAO {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);
    Object getFieldValue(Long id, String fieldName);
}
