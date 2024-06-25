package br.ueg.progweb1.lbbookstore.converter;


import jakarta.persistence.AttributeConverter;

public abstract class BaseConverter<ENUM extends Enum<ENUM>>
        implements AttributeConverter<ENUM, String> {

    @Override
    public String convertToDatabaseColumn(ENUM eEnum) {
        if (eEnum == null) {
            return null;
        }
        return eEnum.name();
    }

    //TODO: Finish abs enum
    @Override
    public ENUM convertToEntityAttribute(String name) {
        return null;
    }
}
