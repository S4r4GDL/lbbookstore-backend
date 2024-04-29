package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<
        Long,
        Book,
        BookDTO,
        BookCreateDTO,
        BookUpdateDTO> 
{
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
}
