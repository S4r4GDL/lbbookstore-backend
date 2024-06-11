package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.cart.dto.CartDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends BasicGenericMapper<Long, Cart, CartDTO> {
}
