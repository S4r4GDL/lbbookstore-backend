package br.ueg.progweb1.lbbookstore.model.cart.dto;

import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import br.ueg.progweb1.lbbookstore.model.client.Client;

import java.math.BigDecimal;
import java.util.Set;

public record CartDTO(Long id,
                      BigDecimal totalPrice,
                      Integer totalQuantity,
                      Set<CartItem> cartItem) {
}
