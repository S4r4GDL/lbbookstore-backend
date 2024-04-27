package br.ueg.progweb1.lbbookstore.model;

public interface GenericModel <PK>{
    void setId(PK id);
    PK getId();
}
