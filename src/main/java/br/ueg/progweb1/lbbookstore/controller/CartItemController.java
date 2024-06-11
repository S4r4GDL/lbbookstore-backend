package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.CartItemMapper;
import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import br.ueg.progweb1.lbbookstore.model.cartItem.dto.CartItemDTO;
import br.ueg.progweb1.lbbookstore.service.CartItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/cart-items")
@CrossOrigin()
public class CartItemController extends CrudController<CartItem, Long,
        CartItemDTO,
        CartItemDTO,
        CartItemDTO,
        CartItemService,
        CartItemMapper>{
}
