package br.ueg.progweb1.lbbookstore.converter;

public interface PersistenceEnum <ENUM extends Enum<ENUM>> {
    ENUM getEnumName();
}
