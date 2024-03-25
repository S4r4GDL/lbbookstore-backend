package br.ueg.progweb1.lbbookstore.model.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookReadDTO {
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private String edition;

    private Integer releaseYear;

    private BigDecimal price;

    private Integer quantity;

    private LocalDate lastUpdate;

    private Boolean active;
}
