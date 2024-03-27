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

    private void prepareToUpdate(Book newBook, Book bookBD) {
        newBook.setLastUpdate(LocalDate.now());
        newBook.setId(bookBD.getId());
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
    public Book update(Book newBook, Long id) {
        validateMandatoryFields(newBook);
        validateBusinessLogicToUpdate(newBook);
        Book bookBD = validateId(id);
        prepareToUpdate(newBook, bookBD);

        return repository.save(newBook);
    }

    private void validateBusinessLogicToUpdate(Book book) {
        if(book.getPrice().intValue() <= 0)
            throw new BusinessLogicException(ErrorValidation.INVALID_PRICE);
        if(book.getQuantity() < 0)
            throw new BusinessLogicException(ErrorValidation.INVALID_QUANTITY);
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

    public Boolean delete(Long id) {
        Book book = validateId(id);
        validateBusinessLogicToDelete(book);
        repository.deleteById(book.getId());
        return repository.findById(id).isEmpty();

    }

    private void validateBusinessLogicToDelete(Book book) {
        if(book.getQuantity() > 0)
            throw new BusinessLogicException(ErrorValidation.INVALID_QUANTITY_TO_DELETE);

    }

    @Override
    public List<Book> getActiveBooks() {
        return repository.findAllByActive(true);
    }
}
