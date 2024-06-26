package br.ueg.progweb1.lbbookstore.model.book.dto;

import java.math.BigDecimal;

public record BookCreateDTO(String name,
                            String author,
                            String publisher,
                            String edition,
                            Integer releaseYear,
                            BigDecimal price,
                            Integer pages,
                            Integer quantity,
                            Boolean active,
                            String description)
{}
