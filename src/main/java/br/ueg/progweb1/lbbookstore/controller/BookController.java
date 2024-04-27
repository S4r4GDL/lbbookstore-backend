package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.MandatoryException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.mapper.BookMapper;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookUpdateDTO;
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
            var response = mapper.fromModelToDTO(service.create(mapper.fromCreateDTOToModel(bookDTO)));
            return ResponseEntity.ok(response);

    }

    @PutMapping(path = "/{id}")
    @Operation(description = "End point to update a book")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateDTO bookDTO)
    {
        var response = mapper.fromModelToDTO(service.update(mapper.fromUpdateDTOtoModel(bookDTO), id));
            return ResponseEntity.ok(response);

    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point to delete a book")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") Long id)
    {
            BookDTO bookDTO = mapper.fromModelToDTO(service.getById(id));
            return ResponseEntity.ok(bookDTO + " Delete worked");
    }

    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity<Object> getAllBooks()
    {
        var response = mapper.fromModelListToDTOList(service.getAll());
        return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id: ")
    public ResponseEntity<Object> getBookById(@PathVariable Long id)
    {
            var response = service.getById(id);
            return ResponseEntity.ok(response);

}

    @GetMapping(path = "/search/actives")
    @Operation(description = "End point to get all active books")
    public ResponseEntity<Object> getActiveBooks()
    {
            var response = service.getActiveBooks();
            return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/search/authors")
    @Operation(description = "End point to get all books by author")
    public ResponseEntity<Object> getBookByAuthor(@RequestParam String author)
    {
        var response = service.getByAuthor(author);
            return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/search/titles")
    @Operation(description = "End point to get all books by title")
    public ResponseEntity<Object> getBookByTitle(@RequestParam String title)
    {

            var response = service.getByTitle(title);
            return ResponseEntity.ok(response);

    }

    @GetMapping("/search/lower-prices")
    @Operation(description = "End point to get all books with prices lower that stipulated")
    public ResponseEntity<Object> getBookByLowerPrice(@RequestParam BigDecimal price)
    {

            var response = service.getByLowerPrice(price);
            return ResponseEntity.ok(response);

    }

    @GetMapping("/search/publishers")
    @Operation(description = "End point to get all books by publisher")
    public ResponseEntity<Object> getBookByPublisher(@RequestParam String publisher)
    {

            var response = service.getByPublisher(publisher);
            return ResponseEntity.ok(response);

    }

    @GetMapping("/search/year")
    @Operation(description = "End point to get all books by release year")
    public ResponseEntity<Object> getBookByReleaseYear (@RequestParam Integer year)
    {

            var response = service.getByReleaseYear(year);
            return ResponseEntity.ok(response);
    }

}
