package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserCreateDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends GenericMapper<Long, User, UserDTO, UserCreateDTO, UserUpdateDTO> {

     @Mapping(source = "password", target = "login.password")
     User fromLoginAuthDTOToModel(LoginAuthDTO loginAuthDTO);

     @Mapping(source = "password", target = "login.password")
     User fromCreateDTOToModel(UserCreateDTO dto);
}
