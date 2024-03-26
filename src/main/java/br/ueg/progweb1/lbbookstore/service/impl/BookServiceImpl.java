package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.exception.BusinessLogicException;
import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.repository.BookRepository;
import br.ueg.progweb1.lbbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

        if(newBook.getPrice().intValue() <= 0)
            throw new BusinessLogicException(ErrorValidation.INVALID_PRICE);
        if(newBook.getQuantity() < 0)
            throw new BusinessLogicException(ErrorValidation.INVALID_QUANTITY);

    }

    private void validateMandatoryFields(Book bookData) {
        if(bookData.getAuthor().isBlank()
                || bookData.getPublisher().isBlank()
                || bookData.getEdition().isBlank()
                || bookData.getTitle().isBlank())
            throw new BusinessLogicException(ErrorValidation.MANDATORY_FIELD_VIOLATION);
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public List<Book> listAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return validateId(id);
    }

    private Book validateId(Long id) {

        Optional<Book> book = repository.findById(id);

        if(book.isEmpty())
            throw new BusinessLogicException(ErrorValidation.INVALID_ID);

        return book.get();
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

    @Override
    public Boolean delete(Book model) {
        return true;
    }

    @Override
    public List<Book> getActiveBooks() {
        return repository.findAllByActive(true);
    }
}
