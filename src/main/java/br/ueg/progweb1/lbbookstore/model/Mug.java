package br.ueg.progweb1.lbbookstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="mug")
@Entity
@EqualsAndHashCode(of="id")
public class Mug implements GenericModel<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="theme", length = 250, nullable = false)
    private String theme;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name="quantity", nullable = false)
    private Integer quantity;

    @Column(name="active", nullable = false)
    private Boolean active;
}
