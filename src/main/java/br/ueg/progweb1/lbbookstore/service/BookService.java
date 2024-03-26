package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book create(Book newBook);

    Book update(Book book);

    List<Book> listAll();

    Book getById(Long id);

    List<Book> getByAuthor(String author);

    List<Book> getByPublisher();

    List<Book> listLowerPrice(BigDecimal limitPrice);

    Boolean delete(Book model);

    List<Book> getActiveBooks();
}
