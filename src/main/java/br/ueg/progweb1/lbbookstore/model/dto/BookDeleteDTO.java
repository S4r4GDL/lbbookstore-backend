package br.ueg.progweb1.lbbookstore.model.dto;

import java.math.BigDecimal;

public record BookDeleteDTO(Long id,
                            String title,
                            String author,
                            String publisher,
                            String edition,
                            Integer releaseYear,
                            BigDecimal price,
                            Integer quantity,
                            Boolean active)
{
}
