package br.ueg.progweb1.lbbookstore.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateBookDTO(String title,
                            String author,
                            String publisher,
                            String edition,
                            Integer releaseYear,
                            BigDecimal price,
                            Integer quantity,
                            LocalDate lastUpdate,
                            Boolean active)
{}
