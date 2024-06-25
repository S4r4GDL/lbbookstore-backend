package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GenericCrudService<Long, User> {
}

