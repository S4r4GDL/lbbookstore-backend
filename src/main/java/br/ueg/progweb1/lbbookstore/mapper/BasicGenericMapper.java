package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.GenericModel;

public interface BasicGenericMapper <PK, MODEL extends GenericModel<? super PK>, DTO>
        extends GenericMapper<PK, MODEL , DTO, DTO, DTO>{
}
