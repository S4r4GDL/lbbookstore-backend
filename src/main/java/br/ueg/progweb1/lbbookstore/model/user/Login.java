package br.ueg.progweb1.lbbookstore.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(of="id")
@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name="user_id")
    protected Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    protected User user;

    //TODO: Learn how to encrypt and decrypt a password
    @Column(name = "password", nullable = false, length = 150)
    protected String password;

}
