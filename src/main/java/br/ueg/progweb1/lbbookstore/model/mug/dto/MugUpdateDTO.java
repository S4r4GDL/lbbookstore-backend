package br.ueg.progweb1.lbbookstore.model.mug.dto;

import java.math.BigDecimal;

public record MugUpdateDTO( Long id,
                            String name,
                            BigDecimal price,
                            Integer mls,
                            Integer quantity)
{}
