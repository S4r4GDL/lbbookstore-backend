package br.ueg.progweb1.lbbookstore.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(of="id")
@MappedSuperclass
public class Product implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    protected Long id;

    @Column(name="price", nullable = false)
    protected BigDecimal price;

    @Column(name="quantity", nullable = false)
    protected Integer quantity;

    @Column(name="last_Updade", nullable = false)
    protected LocalDate lastUpdate;

    @Column(name="active", nullable = false)
    protected Boolean active;

    @Column(name="description", length = 450)
    protected String description;

}
