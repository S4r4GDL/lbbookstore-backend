package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.MandatoryException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.mapper.BookMapper;
import br.ueg.progweb1.lbbookstore.model.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookReadDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookUpdateDTO;
import br.ueg.progweb1.lbbookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping(path = "${api.version}/books")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    BookMapper mapper;

    @PostMapping
    @Operation(description = "End point to create a new book")
    public ResponseEntity<Object> createBook(@RequestBody BookCreateDTO bookDTO)
    {
        String error = "Error while trying to create a book: ";
        try {

            var response = mapper.toDTO(service.create(mapper.toModel(bookDTO)));
            return ResponseEntity.ok(response);

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessException businessException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessException.getMessage()));

        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }


    }

    @PutMapping(path = "{id}")
    @Operation(description = "End point to update a book")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateDTO bookDTO)
    {
        String error = "Error while trying to update a book: ";
        try{

            var response = mapper.toDTO(service.update(mapper.toModel(bookDTO), id));
            return ResponseEntity.ok(response);

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessException businessException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessException.getMessage()));

        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
    }

    @DeleteMapping
    @Operation(description = "End point to delete a book")
    public ResponseEntity<Object> deleteBook(@RequestParam Long id)
    {
        String error = "Error while trying to delete a book: ";

        try{
            BookReadDTO bookDTO = mapper.toDTO(service.getById(id));
            if(service.delete(bookDTO.id()))
                return ResponseEntity.ok(bookDTO + " Delete worked");

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessException businessException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessException.getMessage()));

        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity<Object> getAllBooks()
    {
        String error = "Error while trying to get information about all books: ";

        try{

            var response = service.getAll();
            return ResponseEntity.ok(response);

        } catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new StringBuilder()
                        .append(error)
                        .append(modelDataException.getMessage()));
        }
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id: ")
    public ResponseEntity<Object> getBookById(@PathVariable Long id)
    {
        String error = "Error while trying to get information the book by id: ";
        try {

            var response = service.getById(id);
            return ResponseEntity.ok(response);

        }catch (BusinessException businessException){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessException.getMessage()));

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }
}

    @GetMapping(path = "/search/actives")
    @Operation(description = "End point to get all active books")
    public ResponseEntity<Object> getActiveBooks()
    {
        String error = "Error while trying to get information about active books: ";
        try{

            var response = service.getActiveBooks();
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }

    }

    @GetMapping(path = "/search/authors")
    @Operation(description = "End point to get all books by author")
    public ResponseEntity<Object> getBookByAuthor(@RequestParam String author)
    {
        String error = "Error while trying to get information about this author books: ";
        try {

            var response = service.getByAuthor(author);
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new StringBuilder()
                        .append(error)
                        .append(modelDataException.getMessage()));
        }
    }

    @GetMapping(path = "/search/titles")
    @Operation(description = "End point to get all books by title")
    public ResponseEntity<Object> getBookByTitle(@RequestParam String title)
    {
        String error = "Error while trying to get information about this title: ";
        try {

            var response = service.getByTitle(title);
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }
    }

    @GetMapping("/search/lower-prices")
    @Operation(description = "End point to get all books with prices lower that stipulated")
    public ResponseEntity<Object> getBookByLowerPrice(@RequestParam BigDecimal price)
    {
        String error = "Error while trying to get information about books with lower prices: ";
        try {

            var response = service.getByLowerPrice(price);
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
    }

    @GetMapping("/search/publishers")
    @Operation(description = "End point to get all books by publisher")
    public ResponseEntity<Object> getBookByPublisher(@RequestParam String publisher)
    {
        String error = "Error while trying to get information about books by publisher: ";
        try {

            var response = service.getByPublisher(publisher);
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
    }

    @GetMapping("/search/year")
    @Operation(description = "End point to get all books by release year")
    public ResponseEntity<Object> getBookByReleaseYear (@RequestParam Integer year)
    {
        String error = "Error while trying to get information about books by release year: ";
        try {

            var response = service.getByReleaseYear(year);
            return ResponseEntity.ok(response);

        }catch (ModelDataException modelDataException){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StringBuilder()
                            .append(error)
                            .append(modelDataException.getMessage()));
        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
    }

}
