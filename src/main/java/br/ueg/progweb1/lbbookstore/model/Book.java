package br.ueg.progweb1.lbbookstore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="book")
@Entity
@EqualsAndHashCode(of="id")
    public class Book implements GenericModel<Long> {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name="id")
        private Long id;

        @Column(name="title", length = 250, nullable = false)
        private String title;

        @Column(name="author",  length = 150, nullable = false)
        private String author;

        @Column(name="publisher", length = 150)
        private String publisher;

        @Column(name="edition", length = 150, nullable = false)
        private String edition;

        @Column(name="release_year", nullable = false)
        private Integer releaseYear;

        @Column(name="price", nullable = false)
        private BigDecimal price;

        @Column(name="quantity", nullable = false)
        private Integer quantity;

        @Column(name="last_Updade", nullable = false)
        private LocalDate lastUpdate;

        @Column(name="active", nullable = false)
        private Boolean active;


    }

