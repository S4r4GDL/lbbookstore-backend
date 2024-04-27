package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.GenericModel;

import java.util.List;

public interface GenericMapper<PK, MODEL extends GenericModel<PK>, DTO, CreateDTO, UpdateDTO>{

    MODEL fromCreateDTOToModel(CreateDTO dto);
    MODEL fromUpdateDTOtoModel(UpdateDTO dto);

    DTO fromModelToDTO(MODEL model);

    List<DTO> fromModelListToDTOList(List<MODEL> modelList);

}
