package br.ueg.progweb1.lbbookstore.model.mug.dto;

import java.math.BigDecimal;

public record MugUpdateDTO(String name,
                           BigDecimal price,
                           Integer mls,
                           Integer quantity)
{}
