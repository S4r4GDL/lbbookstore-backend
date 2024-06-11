package br.ueg.progweb1.lbbookstore.model.mug.dto;

import br.ueg.progweb1.lbbookstore.enums.ProductType;

import java.math.BigDecimal;

public record MugDTO(Long id,
                     String name,
                     BigDecimal price,
                     Integer quantity,
                     Integer mls,
                     ProductType type,
                     Boolean active) {
}
