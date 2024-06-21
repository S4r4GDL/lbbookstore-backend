package br.ueg.progweb1.lbbookstore.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "user", callSuper = false)
@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name="user_id")
    protected Long id;


    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    @JsonBackReference
    private  User user;

    @Column(name="password", length = 250)
    protected String password;
}
