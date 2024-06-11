package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.client.Client;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.repository.ClientRepository;
import br.ueg.progweb1.lbbookstore.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientServiceImpl extends CrudService<Client, Long, ClientRepository> implements ClientService {

 @Override
 public Client active(Long id) {
  return null;
 }

 @Override
 protected void validateBasicBusinessLogic(Client model) {

 }

 @Override
 protected void validateBusinessToList(List<Client> clients) {

 }

 @Override
 protected void validateMandatoryFields(Client model) {

 }

 @Override
 protected void prepareToCreate(Client newModel) {
   newModel.setId(null);
   newModel.setDataCreate(LocalDate.now());
   newModel.setLastUpdate(LocalDate.now());
   newModel.setCart(new Cart());
   newModel.setLogin(new Login());
   newModel.getLogin().setUser(newModel);
   newModel.getCart().setClient(newModel);
 }

 @Override
 protected void validateBusinessLogicToCreate(Client newModel) {

 }

 @Override
 protected void prepareToUpdate(Client newModel, Client model) {
     newModel.setLastUpdate(LocalDate.now());
 }

 @Override
 protected void validateBusinessLogicToUpdate(Client model) {

 }

 @Override
 protected void validateBusinessLogicToDelete(Client model) {

 }
}
