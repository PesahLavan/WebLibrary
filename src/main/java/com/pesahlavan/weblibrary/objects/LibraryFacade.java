package com.pesahlavan.weblibrary.objects;


import com.pesahlavan.weblibrary.dao.interfaces.BookDAO;
import com.pesahlavan.weblibrary.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryFacade {


    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }
}