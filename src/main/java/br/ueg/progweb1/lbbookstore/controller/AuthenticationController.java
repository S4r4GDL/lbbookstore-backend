package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.mapper.ClientMapper;
import br.ueg.progweb1.lbbookstore.mapper.UserMapper;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientCreateDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserCreateDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import br.ueg.progweb1.lbbookstore.security.TokenDTO;
import br.ueg.progweb1.lbbookstore.service.ClientService;
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
    ClientService clientService;

    @Autowired
    UserMapper mapper;

    @Autowired
    ClientMapper clientmapper;

    protected static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);




    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginAuthDTO loginAuthDTO) {
        LOG.info("AUTH Login:{}", loginAuthDTO);
        var auth = authService.authenticate(loginAuthDTO);
        LOG.info("AUTH Login:{}", auth);
        return ResponseEntity.ok(auth);

    }

    @PostMapping("/register")
    public ResponseEntity<TokenDTO> create(@RequestBody ClientCreateDTO clientCreateDTO){
        var response = clientService.create(clientmapper.fromCreateDTOToModel(clientCreateDTO));
        LOG.info("AUTH:{}", response);
        var auth = authService.authenticate(new LoginAuthDTO(response.getUsername(), clientCreateDTO.password()));
        LOG.info("AUTH:{}", auth);
        return ResponseEntity.ok(auth);

    }

    @GetMapping("/test")
    public ResponseEntity<LoginAuthDTO> test(@RequestBody LoginAuthDTO loginAuthDTO){
            return ResponseEntity.ok(loginAuthDTO);
    }
}
