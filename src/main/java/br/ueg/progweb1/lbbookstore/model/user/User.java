package br.ueg.progweb1.lbbookstore.model.user;

import br.ueg.progweb1.lbbookstore.enums.UserRole;
import br.ueg.progweb1.lbbookstore.model.GenericModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Column(name="user_name", unique = true, length = 150)
    protected String userName;

    @Column(name="data_create", nullable = false)
    protected LocalDate dataCreate;

    @Column(name="last_update", nullable = false)
    protected LocalDate lastUpdate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    protected Login login;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    protected UserRole role;

}
