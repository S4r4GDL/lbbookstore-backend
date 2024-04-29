package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.mapper.GenericMapper;
import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.service.GenericCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public abstract class CrudController < MODEL extends GenericModel<PK>,
        PK,
        DTO,
        CreateDTO,
        UpdateDTO,
        SERVICE extends GenericCrudService<PK, MODEL>,
        MAPPER extends GenericMapper< PK, MODEL, DTO, CreateDTO, UpdateDTO> >
        implements GenericCrudController < PK, DTO, CreateDTO, UpdateDTO >{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MAPPER mapper;

    protected static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @PostMapping
    @Operation(description = "End point to create a new item")
    @Override
    public ResponseEntity<DTO> create(@RequestBody CreateDTO createDTO){

        LOG.info("Item to create: {}", createDTO);
        var response = mapper.fromModelToDTO(service.create(mapper.fromCreateDTOToModel(createDTO)));
        LOG.info("Item created: {}", response);
        return ResponseEntity.ok(response);

    }

    @PutMapping(path = "/{id}")
    @Operation(description = "End point to update an item")
    @Override
    public ResponseEntity<DTO> update(@PathVariable("id") PK id, @RequestBody UpdateDTO updateDTO) {

        LOG.info("Item to update: {}", updateDTO);
        var response = mapper.fromModelToDTO(service.update(mapper.fromUpdateDTOtoModel(updateDTO), id));
        LOG.info("Item updated: {}", response);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point to delete an item")
    @Override
    public ResponseEntity<DTO> delete(@PathVariable("id") PK id) {

        DTO response = mapper.fromModelToDTO(service.delete(id));
        LOG.info("Item deleted: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(description = "End point to list all items")
    @Override
    public ResponseEntity<List<DTO>> getAllBooks(){

        var response = mapper.fromModelListToDTOList(service.getAll());
        return ResponseEntity.ok(response);

    }
}
