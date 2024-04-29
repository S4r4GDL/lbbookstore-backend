package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.mapper.MugMapper;
import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugCreateDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugUpdateDTO;
import br.ueg.progweb1.lbbookstore.service.MugService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/mugs")
public class MugController extends CrudController<Mug, Long,
        MugDTO,
        MugCreateDTO,
        MugUpdateDTO,
        MugService,
        MugMapper>{

}
