package br.ueg.progweb1.lbbookstore.model.mug;

import br.ueg.progweb1.lbbookstore.model.product.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Table(name="mug")
@Entity
@EqualsAndHashCode(of="id")
public class Mug extends Product{
    @Column(name="mls", nullable = false)
    private Integer msl;
}
