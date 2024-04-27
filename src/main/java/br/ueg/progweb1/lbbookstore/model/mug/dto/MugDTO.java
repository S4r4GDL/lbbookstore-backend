package br.ueg.progweb1.lbbookstore.model.mug.dto;

import java.math.BigDecimal;

public record MugDTO(Long id,
                     String theme,
                     BigDecimal price,
                     Integer quantity,
                     Boolean active) {
}
