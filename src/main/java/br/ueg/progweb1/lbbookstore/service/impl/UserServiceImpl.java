package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.enums.ErrorValidation;
import br.ueg.progweb1.lbbookstore.enums.UserRole;
import br.ueg.progweb1.lbbookstore.exception.BusinessException;
import br.ueg.progweb1.lbbookstore.exception.ModelDataException;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.repository.UserRepository;
import br.ueg.progweb1.lbbookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

 private static final Logger LOG =
         LoggerFactory.getLogger(AppStartupRunner.class);

 @Override
 public User active(Long id) {
  var user = this.repository.getReferenceById(id);
  user.setActive(!user.getActive());
  return this.repository.save(user);
 }

 @Override
 public User updateAccess(User user){
  return update(user);
 }

 @Override
 protected void validateBasicBusinessLogic(User model) {
  LOG.info(String.valueOf(model));
  if ( model.getName().isEmpty() ||
          model.getUsername().isEmpty()
          || Objects.isNull(model.getRole())
          || Objects.isNull(model.getLogin())
          || Objects.isNull(model.getLogin().getPassword()))
   throw new BusinessException(ErrorValidation.MANDATORY_FIELD_VIOLATION);
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
  if(this.repository.findByUsername(newModel.getUsername()).isPresent()){
   throw new ModelDataException(ErrorValidation.MANDATORY_FIELD_VIOLATION);
  }
 }

 @Override
 protected void prepareToUpdate(User newModel, User model) {
  newModel.setLastUpdate(LocalDate.now());
 }

 @Override
 protected void validateBusinessLogicToUpdate(User model) {

 }

 @Override
 protected void validateBusinessLogicToDelete(User model) {

 }

}
