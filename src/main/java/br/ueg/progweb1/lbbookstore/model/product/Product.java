package br.ueg.progweb1.lbbookstore.model.product;

import br.ueg.progweb1.lbbookstore.enums.ProductType;
import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(of="id")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    protected Long id;

    @Column(name="name", length = 150)
    protected String name;

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

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    protected ProductType type;

    @Column(name="rate", length = 450)
    protected String rate;

}
