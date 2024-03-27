package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
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

    @Override
    public Book update(Book newBook, Long id) {
        validateMandatoryFields(newBook);
        validateBusinessLogicToUpdate(newBook);
        Book bookBD = validateId(id);
        prepareToUpdate(newBook, bookBD);

        return repository.save(newBook);
    }

    public Boolean delete(Long id) {
        Book book = validateId(id);
        validateBusinessLogicToDelete(book);
        repository.deleteById(book.getId());
        return repository.findById(id).isEmpty();

    }

    @Override
    public List<Book> getAll() {
        var bookList = repository.findAll();
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public Book getById(Long id) {
        return validateId(id);
    }

    private Book validateId(Long id) {

        Optional<Book> book = repository.findById(id);

        if(book.isEmpty())
            throw new BusinessException(ErrorValidation.INVALID_ID);

        return book.get();
    }

    @Override
    public List<Book> getByAuthor(String author) {
        var bookList = repository.findAllByAuthorContainsIgnoreCase(author);
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByPublisher(String publisher) {
        var bookList = repository.findAllByPublisherContainsIgnoreCase(publisher);
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByReleaseYear(Integer year) {
        var bookList = repository.findAllByReleaseYear(year);
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByLowerPrice(BigDecimal limitPrice) {
        var bookList = repository.findAllByPriceLessThan(limitPrice);
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public List<Book> getActiveBooks() {
        var bookList = repository.findAllByActive(true);
        validateBusinessToGet(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByTitle(String title) {
        var bookList = repository.findAllByTitleContainsIgnoreCase(title);
        validateBusinessToGet(bookList);
        return bookList;
    }

    private void validateBusinessToGet(List<Book> bookList)
    {
        if(bookList.isEmpty())
            throw new ModelDataException(ErrorValidation.NOT_FOUND);
    }

    //Validations
    private void validateMandatoryFields(Book bookData) {

        if(Objects.isNull(bookData.getAuthor())
                || Objects.isNull(bookData.getPublisher())
                || Objects.isNull(bookData.getEdition())
                || Objects.isNull(bookData.getTitle())
                || Objects.isNull(bookData.getQuantity())
                || Objects.isNull(bookData.getPrice()))
            throw new BusinessException(ErrorValidation.MANDATORY_FIELD_VIOLATION);

    }

    private void prepareToCreate(Book newBook) {
        newBook.setId(0L);
        newBook.setLastUpdate(LocalDate.now());
    }


    private void validateBusinessLogicToCreate(Book newBook) {

        if(newBook.getPrice().intValue() <= 0)
            throw new BusinessException(ErrorValidation.INVALID_PRICE);
        if(newBook.getQuantity() < 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY);

    }

    private void prepareToUpdate(Book newBook, Book bookBD) {
        newBook.setLastUpdate(LocalDate.now());
        newBook.setId(bookBD.getId());
    }

    private void validateBusinessLogicToUpdate(Book book) {
        if(book.getPrice().intValue() <= 0)
            throw new BusinessException(ErrorValidation.INVALID_PRICE);
        if(book.getQuantity() < 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY);
    }

    private void validateBusinessLogicToDelete(Book book) {
        if(book.getQuantity() > 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY_TO_DELETE);

    }


}
