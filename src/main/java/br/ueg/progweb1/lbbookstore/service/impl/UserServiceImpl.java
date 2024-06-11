package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.client.Client;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.repository.ClientRepository;
import br.ueg.progweb1.lbbookstore.repository.UserRepository;
import br.ueg.progweb1.lbbookstore.service.ClientService;
import br.ueg.progweb1.lbbookstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends CrudService<User, Long, UserRepository> implements UserService {


 @Override
 public User active(Long id) {
  return null;
 }

 @Override
 protected void validateBasicBusinessLogic(User model) {

 }

 @Override
 protected void validateBusinessToList(List<User> users) {

 }

 @Override
 protected void validateMandatoryFields(User model) {

 }

 @Override
 protected void prepareToCreate(User newModel) {
 }

 @Override
 protected void validateBusinessLogicToCreate(User newModel) {

 }

 @Override
 protected void prepareToUpdate(User newModel, User model) {

 }

 @Override
 protected void validateBusinessLogicToUpdate(User model) {

 }

 @Override
 protected void validateBusinessLogicToDelete(User model) {

 }
}
