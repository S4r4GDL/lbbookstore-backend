package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.book.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService extends GenericCrudService<Long, Book>{

    List<Book> getByAuthor(String author);

    List<Book> getByPublisher(String publisher);

    List<Book> getByReleaseYear(Integer year);

    List<Book> getByLowerPrice(BigDecimal limitPrice);

    List<Book> getActiveBooks();

    List<Book> getByTitle(String title);
}
