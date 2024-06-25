package br.ueg.progweb1.lbbookstore.service.impl;

import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.model.user.dto.LoginAuthDTO;
import br.ueg.progweb1.lbbookstore.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    public final BCryptPasswordEncoder passwordEncoder;
    public final JwtServiceImpl jwtService;

    public AuthenticationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtServiceImpl jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String authenticate(LoginAuthDTO loginAuthDTO) {
        var user = userRepository.findByUserName(loginAuthDTO.userName());
        if (user.isEmpty() ) {
            throw new BadCredentialsException("User or password is invalid");
        }

        var claims = this.jwtService.generateToken(user.get());

        return claims;

    }

    private boolean validatePassword(LoginAuthDTO loginAuthDTO, Optional<User> user) {
        var raw = passwordEncoder.encode(loginAuthDTO.password());
        if(user.isPresent()){

            User mUser = user.get();
            return true;
        }

        return false;
    }

}
