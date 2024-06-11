package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import br.ueg.progweb1.lbbookstore.model.cartItem.dto.CartItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartItemMapper extends GenericMapper<
        Long,
        CartItem,
        CartItemDTO,
        CartItemDTO,
        CartItemDTO>{

    @Mapping( source = "productId", target = "product.id")
    CartItem fromCreateDTOToModel(CartItemDTO cartItemDTO);

}
