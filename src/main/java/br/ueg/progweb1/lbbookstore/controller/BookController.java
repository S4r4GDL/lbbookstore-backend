package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.mapper.BookMapper;
import br.ueg.progweb1.lbbookstore.model.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/book")
public class BookController {
    @Autowired
    BookService service;

    @Autowired
    BookMapper mapper;

    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity<Object> getAllBooks()
    {
        var response = "Get working";
        return ResponseEntity.ok(response);
    }
    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id")
    public ResponseEntity<Object> getBookById(@PathVariable String id)
    {
        var response = "Get book by id working" + id;
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(description = "End point to create a new book")
    public ResponseEntity<Object> createBook(@RequestBody BookCreateDTO bookDTO)
    {
        var response = service.create(mapper.toModel(bookDTO));
        return ResponseEntity.ok(response);
    }

}
