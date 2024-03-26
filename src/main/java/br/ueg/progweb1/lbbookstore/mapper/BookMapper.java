package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.model.dto.BookDeleteDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookReadDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(BookCreateDTO bookCreateDTO){
        Book book = new Book();
        book.setAuthor(bookCreateDTO.author());
        book.setTitle(bookCreateDTO.title());
        book.setPublisher(bookCreateDTO.publisher());
        book.setEdition(bookCreateDTO.edition());
        book.setReleaseYear(bookCreateDTO.releaseYear());
        book.setPrice(bookCreateDTO.price());
        book.setQuantity(bookCreateDTO.quantity());
        book.setActive(bookCreateDTO.active());
        return book;
    }

    public Book toModel(BookUpdateDTO bookUpdateDTO){
        Book book = new Book();
        book.setAuthor(bookUpdateDTO.author());
        book.setTitle(bookUpdateDTO.title());
        book.setPublisher(bookUpdateDTO.publisher());
        book.setEdition(bookUpdateDTO.edition());
        book.setReleaseYear(bookUpdateDTO.releaseYear());
        book.setPrice(bookUpdateDTO.price());
        book.setQuantity(bookUpdateDTO.quantity());
        book.setActive(bookUpdateDTO.active());
        return book;
    }

    public BookReadDTO toDTO(Book book){
        BookReadDTO bookReadDTO = new BookReadDTO(
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
        return bookReadDTO;
    }

}
