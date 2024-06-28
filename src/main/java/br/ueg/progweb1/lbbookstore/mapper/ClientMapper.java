package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.client.Client;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientCreateDTO;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientDTO;
import br.ueg.progweb1.lbbookstore.model.client.dto.ClientUpdateDTO;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper extends GenericMapper<Long, Client, ClientDTO, ClientCreateDTO, ClientUpdateDTO> {

    @Override
    @Mapping(source = "password", target = "login.password")
    Client fromCreateDTOToModel(ClientCreateDTO dto);


}