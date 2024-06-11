package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.CartMapper;
import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.cart.dto.CartDTO;
import br.ueg.progweb1.lbbookstore.service.CartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/cart")
@CrossOrigin()
public class CartController extends CrudController<Cart, Long,
        CartDTO,
        CartDTO,
        CartDTO,
        CartService,
        CartMapper>{

}
