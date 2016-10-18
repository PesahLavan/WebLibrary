package com.pesahlavan.weblibrary.dao.impl;

import com.pesahlavan.weblibrary.dao.interfaces.LibraryDAO;
import com.pesahlavan.weblibrary.entities.Author;
import com.pesahlavan.weblibrary.entities.Book;
import com.pesahlavan.weblibrary.entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LibraryDaoImpl implements LibraryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    public LibraryDaoImpl() {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("genre"), "genre");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("isbn"), "isbn");
        bookProjection.add(Projections.property("publisher"), "publisher");
        bookProjection.add(Projections.property("author"), "author");
        bookProjection.add(Projections.property("publishYear"), "publishYear");
        bookProjection.add(Projections.property("descr"), "descr");
        bookProjection.add(Projections.property("rating"), "rating");
        bookProjection.add(Projections.property("voteCount"), "voteCount");
    }


    @Transactional
    @Override
    public List<Book> getBooks() {
        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(Book.class, "b");
        createAliases(bookListCriteria);

        List<Book> books = createBookList(bookListCriteria);

        return books;
    }

    @Override
    public List<Book> getBooks(Author author) {
        return null;
    }

    @Override
    public List<Book> getBooks(String bookName) {
        return null;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        return null;
    }

    @Override
    public List<Book> getBooks(Character letter) {
        return null;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("b.author", "author");
        criteria.createAlias("b.genre", "genre");
        criteria.createAlias("b.publisher", "publisher");
    }


    private List<Book> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }

}
