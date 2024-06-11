package br.ueg.progweb1.lbbookstore.repository;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
