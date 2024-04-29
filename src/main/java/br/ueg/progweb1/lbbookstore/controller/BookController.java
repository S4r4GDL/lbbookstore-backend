package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.mapper.BookMapper;
import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookUpdateDTO;
import br.ueg.progweb1.lbbookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping(path = "${api.version}/books")
public class BookController extends CrudController<Book, Long,
        BookDTO,
        BookCreateDTO,
        BookUpdateDTO,
        BookService,
        BookMapper>{

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
