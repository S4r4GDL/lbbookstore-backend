package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.model.dto.ReadBookDTO;
import br.ueg.progweb1.lbbookstore.model.dto.CreateBookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(CreateBookDTO bookCreateDTO){
        Book book = new Book();
        book.setAuthor(bookCreateDTO.author());
        book.setTitle(bookCreateDTO.title());
        book.setPublisher(bookCreateDTO.publisher());
        book.setEdition(bookCreateDTO.edition());
        book.setReleaseYear(bookCreateDTO.releaseYear());
        book.setPrice(bookCreateDTO.price());
        book.setQuantity(bookCreateDTO.quantity());
        book.setActive(bookCreateDTO.active());
        book.setLastUpdate(bookCreateDTO.lastUpdate());
        return book;
    }
    public ReadBookDTO toDTO(Book book){
        ReadBookDTO readBookDTO = new ReadBookDTO(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublisher(),
                book.getEdition(),
                book.getReleaseYear(),
                book.getPrice(),
                book.getQuantity(),
                book.getLastUpdate(),
                book.getActive());
        return readBookDTO;
    }

}
