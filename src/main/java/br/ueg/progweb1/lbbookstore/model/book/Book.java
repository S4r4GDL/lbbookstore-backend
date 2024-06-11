package br.ueg.progweb1.lbbookstore.model.book;

import br.ueg.progweb1.lbbookstore.model.product.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Table(name="book")
@Entity
public class Book extends Product{

        @Column(name="author",  length = 150, nullable = false)
        private String author;

        @Column(name="publisher", length = 150)
        private String publisher;

        @Column(name="edition", length = 150, nullable = false)
        private String edition;

        @Column(name="pages")
        private Integer pages;

        @Column(name="release_year", nullable = false)
        private Integer releaseYear;

    }

