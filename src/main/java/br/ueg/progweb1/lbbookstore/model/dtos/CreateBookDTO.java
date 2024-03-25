package br.ueg.progweb1.lbbookstore.model.dtos;

import lombok.*;

import java.math.BigDecimal;
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDTO {
    private String title;

    private String author;

    private String publisher;

    private String edition;

    private Integer releaseYear;

    private BigDecimal price;

    private Integer quantity;

    private Boolean active;
}
