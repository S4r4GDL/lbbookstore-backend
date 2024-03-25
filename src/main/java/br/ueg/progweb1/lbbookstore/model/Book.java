package br.ueg.progweb1.lbbookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name="book")
    @Entity
    @EqualsAndHashCode(of="id")
    public class Book {

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

        @Column(name="price", nullable = false, precision = 17)
        private BigDecimal price;

        @Column(name="quantity", nullable = false)
        private Integer quantity;

        @Column(name="last_Updade", nullable = false)
        private Boolean lastUpdate;

        @Column(name="active", nullable = false)
        private Boolean active;


    }

