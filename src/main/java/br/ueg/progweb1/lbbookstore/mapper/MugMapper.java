package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookDTO;
import br.ueg.progweb1.lbbookstore.model.book.dto.BookUpdateDTO;
import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugCreateDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugUpdateDTO;

public interface MugMapper extends GenericMapper<
        Long,
        Mug,
        MugDTO,
        MugCreateDTO,
        MugUpdateDTO>
{}