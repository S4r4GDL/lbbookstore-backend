package br.ueg.progweb1.lbbookstore.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/book")
public class BookController {
    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity getAllBooks()
    {
        var response = "Get working";
        return ResponseEntity.ok(response);
    }
    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id")
    public ResponseEntity getBookById(@PathVariable String id)
    {
        var response = "Get book by id working" + id;
        return ResponseEntity.ok(response);
    }

}
