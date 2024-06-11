package br.ueg.progweb1.lbbookstore.model.client;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Table(name = "client")
@Entity
public class Client extends User {

    @Column(name = "phone_number")
    protected Long phoneNumber;

    @Column(name = "national_register")
    protected Long nationalRegisterNumber;

    @Column(name = "data_birth")
    protected LocalDate dataBirth;

    @Column(name = "score")
    protected Integer score;

    //TODO: One to one between cart and client

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    protected Cart cart;

}
