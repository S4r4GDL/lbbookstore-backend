package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    Book create(Book newBook);

    Book update(Book book, Long id);

    List<Book> listAll();

    Book getById(Long id);

    List<Book> getByAuthor(String author);

    List<Book> getByPublisher();

    List<Book> listLowerPrice(BigDecimal limitPrice);

    Boolean delete(Long id);

    List<Book> getActiveBooks();

    List<Book> getByTitle(String title);
}
