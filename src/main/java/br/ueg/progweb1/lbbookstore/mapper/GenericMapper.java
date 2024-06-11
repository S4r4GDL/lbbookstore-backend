package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.GenericModel;

import java.util.List;

public interface GenericMapper<PK,
        MODEL extends GenericModel<? super PK>, DTO, CreateDTO, UpdateDTO>
{


    MODEL fromCreateDTOToModel(CreateDTO dto);
    MODEL fromUpdateDTOToModel(UpdateDTO dto);
    DTO fromModelToDTO(MODEL model);
    MODEL fromDTOToModel(DTO dto);
    List<DTO> fromModelListToDTOList(List<MODEL> modelList);

}
