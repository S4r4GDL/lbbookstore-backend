package br.ueg.progweb1.lbbookstore.model.cart;

import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import br.ueg.progweb1.lbbookstore.model.client.Client;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(of="id")
@Table(name="cart")
@Entity
public class Cart implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    protected Long id;

    @Transient
    protected BigDecimal totalPrice;

    @Transient
    protected Integer totalQuantity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="cart")
    private Set<CartItem> cartItem;

    //TODO: One to one between cart and client
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;



}
