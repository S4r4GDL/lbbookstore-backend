package br.ueg.progweb1.lbbookstore.converter;

import br.ueg.progweb1.lbbookstore.enums.ProductType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType productType) {
        if (productType == null) {
            return null;
        }
        return productType.getTypeName();
    }

    @Override
    public ProductType convertToEntityAttribute(String s) {
        return ProductType.valueOf(s);
    }
}
