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
import java.util.List;


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
    public ResponseEntity<List<BookDTO>> getActiveBooks()
    {
        var response = mapper.fromModelListToDTOList(service.getActiveBooks());
        return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/search/authors")
    @Operation(description = "End point to get all books by author")
    public ResponseEntity<List<BookDTO>> getBookByAuthor(@RequestParam String author)
    {
        var response = mapper.fromModelListToDTOList(service.getByAuthor(author));
        return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/search/titles")
    @Operation(description = "End point to get all books by title")
    public ResponseEntity<List<BookDTO>> getBookByTitle(@RequestParam String title)
    {

        var response = mapper.fromModelListToDTOList(service.getByTitle(title));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/search/lower-prices")
    @Operation(description = "End point to get all books with prices lower that stipulated")
    public ResponseEntity<List<BookDTO>> getBookByLowerPrice(@RequestParam BigDecimal price)
    {

        var response = mapper.fromModelListToDTOList(service.getByLowerPrice(price));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/search/publishers")
    @Operation(description = "End point to get all books by publisher")
    public ResponseEntity<List<BookDTO>> getBookByPublisher(@RequestParam String publisher)
    {

        var response = mapper.fromModelListToDTOList(service.getByPublisher(publisher));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/search/year")
    @Operation(description = "End point to get all books by release year")
    public ResponseEntity<List<BookDTO>> getBookByReleaseYear (@RequestParam Integer year)
    {
        var response = mapper.fromModelListToDTOList(service.getByReleaseYear(year));
        return ResponseEntity.ok(response);
    }


}
