package br.ueg.progweb1.lbbookstore.model.client.dto;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;

import java.time.LocalDate;

public record ClientDTO(Long id,
                        String name,
                        String userName,
                        LocalDate dataBirth,
                        Integer score,
                        Cart cart) {
}
