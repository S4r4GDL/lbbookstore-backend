package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.UserMapper;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserCreateDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserUpdateDTO;
import br.ueg.progweb1.lbbookstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/user")
@CrossOrigin()
public class UserController extends CrudController<User, Long,
        UserDTO,
        UserCreateDTO,
        UserUpdateDTO,
        UserService,
        UserMapper>{

    @PostMapping("/change-access")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<UserDTO> updateAccess(@RequestBody UserUpdateDTO userUpdateDTO){
        var response =  this.service.updateAccess(mapper.fromUpdateDTOToModel(userUpdateDTO));
        return ResponseEntity.ok(mapper.fromModelToDTO(response));

    }
}
