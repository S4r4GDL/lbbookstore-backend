package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.UserMapper;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import br.ueg.progweb1.lbbookstore.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/user")
@CrossOrigin()
public class UserController extends CrudController<User, Long,
        UserDTO,
        UserDTO,
        UserDTO,
        UserService,
        UserMapper>{
}
