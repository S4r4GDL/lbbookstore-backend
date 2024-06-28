package br.ueg.progweb1.lbbookstore.converter;

import br.ueg.progweb1.lbbookstore.enums.ProductType;
import br.ueg.progweb1.lbbookstore.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.getName();
    }

    @Override
    public UserRole convertToEntityAttribute(String s) {
        return UserRole.valueOf(s);
    }
}
