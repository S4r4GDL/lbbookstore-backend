package br.ueg.progweb1.lbbookstore.model.mug;

import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.model.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Table(name="mug")
@Entity
@EqualsAndHashCode(of="id")
public class Mug extends Product{

    @Column(name="theme", length = 250, nullable = false)
    private String theme;

}
