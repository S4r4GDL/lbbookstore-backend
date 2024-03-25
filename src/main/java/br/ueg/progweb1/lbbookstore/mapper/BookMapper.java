package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.model.dto.CreateBookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(CreateBookDTO bookDTO){
        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setPublisher(bookDTO.getPublisher());
        book.setEdition(bookDTO.getEdition());
        book.setReleaseYear(bookDTO.getReleaseYear());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setActive(bookDTO.getActive());
        book.setLastUpdate(bookDTO.getLastUpdate());
        return book;
    }
}
