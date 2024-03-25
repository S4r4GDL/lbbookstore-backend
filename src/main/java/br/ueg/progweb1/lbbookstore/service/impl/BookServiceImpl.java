package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book create(Book newBook) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public List<Book> listAll() {
        return null;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getByPublisher() {
        return null;
    }

    @Override
    public List<Book> listLowerPrice(BigDecimal limitPrice) {
        return null;
    }
}
