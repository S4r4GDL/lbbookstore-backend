package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.mapper.UserMapper;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserCreateDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import br.ueg.progweb1.lbbookstore.service.UserService;
import br.ueg.progweb1.lbbookstore.service.impl.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/auth")
@CrossOrigin()
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authService;

    @Autowired
    UserMapper mapper;

    protected static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);




    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginAuthDTO loginAuthDTO) {

        var auth = authService.authenticate(loginAuthDTO);
        LOG.info("AUTH:{}", auth);
        return ResponseEntity.ok(auth);

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO userCreateDTO){
        var response =  userService.create(mapper.fromCreateDTOToModel(userCreateDTO));
        return ResponseEntity.ok(mapper.fromModelToDTO(response));

    }

    @GetMapping("/test")
    public ResponseEntity<LoginAuthDTO> teste(@RequestBody LoginAuthDTO loginAuthDTO){
        var data = loginAuthDTO;
            return ResponseEntity.ok(loginAuthDTO);
    }
}
