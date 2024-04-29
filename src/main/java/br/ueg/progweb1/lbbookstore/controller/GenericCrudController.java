package br.ueg.progweb1.lbbookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

public interface GenericCrudController < PK, DTO, CreateDTO, UpdateDTO  > {

    ResponseEntity<DTO> create(@RequestBody CreateDTO createDTO);
    ResponseEntity<DTO> update(@PathVariable("id") PK id, @RequestBody UpdateDTO updateDTO);
    ResponseEntity<DTO> getItemById(@PathVariable PK id);
    ResponseEntity<DTO> delete(@PathVariable("id") PK id);
    ResponseEntity<List<DTO>> getAllItems();
}
