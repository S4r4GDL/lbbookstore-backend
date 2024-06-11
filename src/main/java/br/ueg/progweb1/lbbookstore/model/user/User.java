package br.ueg.progweb1.lbbookstore.model.user;

import br.ueg.progweb1.lbbookstore.model.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(of="id")
@Entity
@Table(name = "_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements GenericModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    protected Long id;

    @Column(name="name", length = 150)
    protected String name;

    @Column(name="email", length = 150)
    protected String email;

    @Column(name="data_create", nullable = false)
    protected LocalDate dataCreate;

    @Column(name="last_Updade", nullable = false)
    protected LocalDate lastUpdate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected Login login;

}
