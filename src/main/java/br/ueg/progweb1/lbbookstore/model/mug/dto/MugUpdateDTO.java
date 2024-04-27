package br.ueg.progweb1.lbbookstore.model.mug.dto;

import java.math.BigDecimal;

public record MugUpdateDTO(String theme,
                           BigDecimal price,
                           Integer quantity)
{}
