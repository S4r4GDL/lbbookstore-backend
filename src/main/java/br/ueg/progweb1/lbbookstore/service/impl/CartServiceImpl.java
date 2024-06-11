package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.repository.CartRepository;
import br.ueg.progweb1.lbbookstore.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends CrudService<Cart, Long, CartRepository> implements CartService {

   //TODO: Add the business logic in cartService
    @Override
    public Cart active(Long id) {
        return null;
    }

    @Override
    protected void validateBasicBusinessLogic(Cart model) {

    }

    @Override
    protected void validateBusinessToList(List<Cart> carts) {

    }

    @Override
    protected void validateMandatoryFields(Cart model) {

    }

    @Override
    protected void prepareToCreate(Cart newModel) {

    }

    @Override
    protected void validateBusinessLogicToCreate(Cart newModel) {

    }

    @Override
    protected void prepareToUpdate(Cart newModel, Cart model) {

    }

    @Override
    protected void validateBusinessLogicToUpdate(Cart model) {

    }

    @Override
    protected void validateBusinessLogicToDelete(Cart model) {

    }
}
