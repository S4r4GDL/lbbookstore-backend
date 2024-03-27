package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.exception.BusinessLogicException;
import br.ueg.progweb1.lbbookstore.exception.MandatoryException;
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


@RestController
@RequestMapping(path = "${api.version}/book")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    BookMapper mapper;

    @PostMapping
    @Operation(description = "End point to create a new book")
    public ResponseEntity<Object> createBook(@RequestBody BookCreateDTO bookDTO)
    {
        String error = "Error while trying to create a book:";
        try {

            var response = mapper.toDTO(service.create(mapper.toModel(bookDTO)));
            return ResponseEntity.ok(response);

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessLogicException businessLogicException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessLogicException.getMessage()));

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
        String error = "Error while trying to update a book:";
        try{

            var response = mapper.toDTO(service.update(mapper.toModel(bookDTO), id));
            return ResponseEntity.ok(response);

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessLogicException businessLogicException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessLogicException.getMessage()));

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
    public ResponseEntity<Object> deleteBook(@RequestBody Long id)
    {
        String error = "Error while trying to delete a book:";

        try{
            BookReadDTO bookDTO = mapper.toDTO(service.getById(id));
            if(service.delete(bookDTO.id()))
                return ResponseEntity.ok(bookDTO.toString() + " Delete worked");

        }catch (MandatoryException mandatoryException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(mandatoryException.getMessage()));

        }catch (BusinessLogicException businessLogicException){

            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body(new StringBuilder()
                            .append(error)
                            .append(businessLogicException.getMessage()));

        }catch (Exception exception)
        {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new StringBuilder()
                            .append(error)
                            .append(exception.getMessage()));

        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity<Object> getAllBooks()
    {
        var response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id")
    public ResponseEntity<Object> getBookById(@PathVariable Long id)
    {
        var response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/")
    @Operation(description = "End point to get all active books")
    public ResponseEntity<Object> getActiveBooks()
    {
        var response = service.getActiveBooks();
        return ResponseEntity.ok(response);
    }
}
