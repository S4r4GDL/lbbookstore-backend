package br.ueg.progweb1.lbbookstore.repository;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
