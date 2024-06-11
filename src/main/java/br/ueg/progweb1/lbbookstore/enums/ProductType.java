package br.ueg.progweb1.lbbookstore.enums;

import lombok.Getter;

@Getter
public enum ProductType {
    MUG(1L, "Mug"),
    BOOK(2L, "Book");

    private Long typeCode;
    private String typeName;

    ProductType(Long typeCode, String typeName){
       this.typeCode = typeCode;
       this.typeName = typeName;
    }

}
