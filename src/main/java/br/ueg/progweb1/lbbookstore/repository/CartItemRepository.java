package br.ueg.progweb1.lbbookstore.repository;

import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
