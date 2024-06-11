package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.product.Product;
import br.ueg.progweb1.lbbookstore.model.cartItem.CartItem;
import br.ueg.progweb1.lbbookstore.repository.CartItemRepository;
import br.ueg.progweb1.lbbookstore.repository.ProductRepository;
import br.ueg.progweb1.lbbookstore.service.CartItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl extends CrudService<CartItem, Long, CartItemRepository> implements CartItemService {

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public CartItem active(Long id) {
        return null;
    }

    @Override
    protected void validateBasicBusinessLogic(CartItem model) {

    }

    @Override
    protected void validateBusinessToList(List<CartItem> cartItems) {

    }

    @Override
    protected void validateMandatoryFields(CartItem model) {

    }

    @Override
    protected void prepareToCreate(CartItem newModel) {
        newModel.setId(null);
        newModel.setCart(new Cart());
        Optional<Product> product = productRepository.findById(newModel.getProduct().getId());

        if(product.isEmpty())
            throw new BusinessException(ErrorValidation.INVALID_ID);
       newModel.setProduct(product.get());
    }

    @Override
    protected void validateBusinessLogicToCreate(CartItem newModel) {

    }

    @Override
    protected void prepareToUpdate(CartItem newModel, CartItem model) {

    }

    @Override
    protected void validateBusinessLogicToUpdate(CartItem model) {

    }

    @Override
    protected void validateBusinessLogicToDelete(CartItem model) {

    }
}
