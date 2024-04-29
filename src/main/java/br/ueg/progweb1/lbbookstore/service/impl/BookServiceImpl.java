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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    protected void validateBusinessToGet(List<Book> bookList)
    {
        if(bookList.isEmpty())
            throw new ModelDataException(ErrorValidation.NOT_FOUND);
    }

    //Validations
    protected void validateMandatoryFields(Book bookData) {
        LOG.info(String.valueOf(bookData));
        if(Objects.isNull(bookData.getAuthor())
                || Objects.isNull(bookData.getPublisher())
                || Objects.isNull(bookData.getEdition())
                || Objects.isNull(bookData.getTitle())
                || Objects.isNull(bookData.getQuantity())
                || Objects.isNull(bookData.getPrice())
                || Objects.isNull(bookData.getReleaseYear()))
            throw new BusinessException(ErrorValidation.MANDATORY_FIELD_VIOLATION);

    }

    protected void prepareToCreate(Book newBook) {
        newBook.setId(0L);
        newBook.setLastUpdate(LocalDate.now());
        LOG.info(String.valueOf(newBook));
    }


    protected void validateBusinessLogicToCreate(Book newBook) {

        validateBasicBusinessLogic(newBook);

    }

    protected void validateBasicBusinessLogic(Book book) {
        if(book.getPrice().intValue() <= 0)
            throw new BusinessException(ErrorValidation.INVALID_PRICE);
        if(book.getQuantity() < 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY);
        if(book.getReleaseYear() < 0 || book.getReleaseYear() > LocalDate.now().getYear())
            throw new BusinessException(ErrorValidation.INVALID_YEAR);
    }

    protected void prepareToUpdate(Book newBook, Book bookBD) {
        newBook.setLastUpdate(LocalDate.now());
        newBook.setId(bookBD.getId());
    }

    protected void validateBusinessLogicToUpdate(Book book) {
        validateBasicBusinessLogic(book);
    }

    protected void validateBusinessLogicToDelete(Book book) {
        if(book.getQuantity() > 0)
            throw new BusinessException(ErrorValidation.INVALID_QUANTITY_TO_DELETE);

    }


}
