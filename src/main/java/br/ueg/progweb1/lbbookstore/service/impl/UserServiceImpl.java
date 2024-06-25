package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.enums.UserRole;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.repository.UserRepository;
import br.ueg.progweb1.lbbookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends CrudService<User, Long, UserRepository> implements UserService{

 @Autowired
 private BCryptPasswordEncoder passwordEncoder;

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
  newModel.setId(0L);
  var key =  newModel.getLogin().getPassword();
  newModel.setLastUpdate(LocalDate.now());
  newModel.setDataCreate(LocalDate.now());
  newModel.setLogin(new Login());
  newModel.getLogin().setUser(newModel);
  newModel.getLogin().setPassword(passwordEncoder.encode(key));
  if(Objects.isNull(newModel.getRole())){
   newModel.setRole(UserRole.USER);
  }


 }

 @Override
 protected void validateBusinessLogicToCreate(User newModel) {
  if(this.repository.findByUserName(newModel.getUserName()).isPresent()){
   throw new ModelDataException(ErrorValidation.MANDATORY_FIELD_VIOLATION);
  }
 }

 @Override
 protected void prepareToUpdate(User newModel, User model) {
  model.setRole(newModel.getRole());
 }

 @Override
 protected void validateBusinessLogicToUpdate(User model) {

 }

 @Override
 protected void validateBusinessLogicToDelete(User model) {

 }

}
