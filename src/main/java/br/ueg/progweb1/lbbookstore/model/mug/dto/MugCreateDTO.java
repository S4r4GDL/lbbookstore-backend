package br.ueg.progweb1.lbbookstore.model.mug.dto;

import java.math.BigDecimal;

public record MugCreateDTO(String name,
                           BigDecimal price,
                           Integer quantity,
                           Integer mls,
                           Boolean active) {
}
