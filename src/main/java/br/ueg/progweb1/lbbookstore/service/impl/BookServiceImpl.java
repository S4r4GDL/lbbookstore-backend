package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.repository.BookRepository;
import br.ueg.progweb1.lbbookstore.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class BookServiceImpl extends CrudService<Book, Long, BookRepository > implements BookService {
    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    public List<Book> getByAuthor(String author) {
        var bookList = repository.findAllByAuthorContainsIgnoreCase(author);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByPublisher(String publisher) {
        var bookList = repository.findAllByPublisherContainsIgnoreCase(publisher);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByReleaseYear(Integer year) {
        var bookList = repository.findAllByReleaseYear(year);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByLowerPrice(BigDecimal limitPrice) {
        var bookList = repository.findAllByPriceLessThan(limitPrice);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    public List<Book> getActiveBooks() {
        var bookList = repository.findAllByActive(true);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    public List<Book> getByTitle(String title) {
        var bookList = repository.findAllByTitleContainsIgnoreCase(title);
        validateBusinessToList(bookList);
        return bookList;
    }

    @Override
    protected void validateBusinessToList(List<Book> bookList)
    {
        if(bookList.isEmpty())
            throw new ModelDataException(ErrorValidation.NOT_FOUND);
    }

    //Validations
    @Override
    protected void validateMandatoryFields(Book bookData) {
        LOG.info(String.valueOf(bookData));
        if ( bookData.getTitle().isEmpty() ||
                bookData.getAuthor().isEmpty()
                || bookData.getPublisher().isEmpty()
                || bookData.getEdition().isEmpty()
                || Objects.isNull(bookData.getQuantity())
                || Objects.isNull(bookData.getPrice())
                || Objects.isNull(bookData.getReleaseYear()))
            throw new BusinessException(ErrorValidation.MANDATORY_FIELD_VIOLATION);

    }

    @Override
    protected void prepareToCreate(Book newBook) {
        newBook.setId(0L);
        newBook.setLastUpdate(LocalDate.now());
        LOG.info(String.valueOf(newBook));
    }


    @Override
    protected void validateBusinessLogicToCreate(Book newBook) {
        validateBasicBusinessLogic(newBook);
    }

    @Override
    protected void validateBasicBusinessLogic(Book book) {
        if(book.getPrice().intValue() <= 0)
            throw new BusinessException(ErrorValidation.INVALID_PRICE);
        if(book.getQuantity() < 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY);
        if(book.getReleaseYear() < 0 || book.getReleaseYear() > LocalDate.now().getYear())
            throw new BusinessException(ErrorValidation.INVALID_YEAR);
    }

    @Override
    protected void prepareToUpdate(Book newBook, Book bookBD) {
        newBook.setLastUpdate(LocalDate.now());
        newBook.setId(bookBD.getId());
        newBook.setActive(bookBD.getActive());
    }

    @Override
    protected void validateBusinessLogicToUpdate(Book book) {
        validateBasicBusinessLogic(book);
    }

    @Override
    protected void validateBusinessLogicToDelete(Book book) {
        if(book.getQuantity() > 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY_TO_DELETE);
        if(book.getActive())
            throw new BusinessException(ErrorValidation.INVALID_STATUS_TO_DELETE);
    }

    @Override
    public Book active(Long id) {
        Book book = validateId(id);
        book.setActive(!(book.getActive()));
        repository.save(book);
        return book;
    }
}
