package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends BasicGenericMapper<Long, User, UserDTO> {
}
