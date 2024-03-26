package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.repository.BookRepository;
import br.ueg.progweb1.lbbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;
    @Override
    public Book create(Book newBook) {
        validateMandatoryFields(newBook);
        validateBusinessLogicToCreate(newBook);
        prepareToCreate(newBook);
        return repository.save(newBook);
    }

    private void prepareToCreate(Book newBook) {
        newBook.setId(0L);
        newBook.setLastUpdate(LocalDate.now());
    }

    private void prepareToUpdate(Book newBook) {
        newBook.setLastUpdate(LocalDate.now());
    }

    private void validateBusinessLogicToCreate(Book newBook) {


    }

    private void validateMandatoryFields(Book newBook) {
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
