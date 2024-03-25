package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.model.dto.BookReadDTO;
import br.ueg.progweb1.lbbookstore.model.dto.CreateBookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(CreateBookDTO bookCreateDTO){
        Book book = new Book();
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setTitle(bookCreateDTO.getTitle());
        book.setPublisher(bookCreateDTO.getPublisher());
        book.setEdition(bookCreateDTO.getEdition());
        book.setReleaseYear(bookCreateDTO.getReleaseYear());
        book.setPrice(bookCreateDTO.getPrice());
        book.setQuantity(bookCreateDTO.getQuantity());
        book.setActive(bookCreateDTO.getActive());
        book.setLastUpdate(bookCreateDTO.getLastUpdate());
        return book;
    }
    public BookReadDTO toDTO(Book book){
        BookReadDTO bookReadDTO = new BookReadDTO();
        bookReadDTO.setAuthor(book.getAuthor());
        bookReadDTO.setTitle(book.getTitle());
        bookReadDTO.setPublisher(book.getPublisher());
        bookReadDTO.setEdition(book.getEdition());
        bookReadDTO.setReleaseYear(book.getReleaseYear());
        bookReadDTO.setPrice(book.getPrice());
        bookReadDTO.setQuantity(book.getQuantity());
        bookReadDTO.setActive(book.getActive());
        bookReadDTO.setLastUpdate(book.getLastUpdate());
        return bookReadDTO;
    }

}
