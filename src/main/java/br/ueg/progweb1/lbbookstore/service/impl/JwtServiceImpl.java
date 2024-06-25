package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl {

    private final JwtEncoder jwtEncoder;

    @Value("${spring.application.name}")
    private String issuer;

    public JwtServiceImpl(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(User user)
    {
        Instant now = Instant.now();
        long expiry = 4000L;
        String scopes = user.getRole().toString();

        var claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(user.getUserName())
                .claim("scope", scopes)
                .build();

        var token =  jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return token;
    }
}
