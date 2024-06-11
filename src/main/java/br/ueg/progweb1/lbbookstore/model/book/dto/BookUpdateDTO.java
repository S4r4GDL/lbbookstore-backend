package br.ueg.progweb1.lbbookstore.model.book.dto;

import java.math.BigDecimal;

public record BookUpdateDTO(String name,
                            String author,
                            String publisher,
                            String edition,
                            Integer releaseYear,
                            BigDecimal price,
                            Integer pages,
                            Integer quantity,
                            String description,
                            Boolean active)
{}
