package br.ueg.progweb1.lbbookstore.model.cartItem.dto;

import java.math.BigDecimal;

public record CartItemDTO(Long id,
                          BigDecimal price,
                          Integer quantity,
                          Long productId) {
}
