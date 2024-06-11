package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper extends GenericMapper<
        Long,
        Book,
        BookDTO,
        BookCreateDTO,
        BookUpdateDTO> 
{}
