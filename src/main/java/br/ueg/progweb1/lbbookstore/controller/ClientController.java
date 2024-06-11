package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.ClientMapper;
import br.ueg.progweb1.lbbookstore.model.client.Client;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientCreateDTO;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientDTO;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientUpdateDTO;
import br.ueg.progweb1.lbbookstore.service.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/client")
@CrossOrigin()
public class ClientController extends CrudController<Client, Long,
        ClientDTO,
        ClientCreateDTO,
        ClientUpdateDTO,
        ClientService,
        ClientMapper>{

}
