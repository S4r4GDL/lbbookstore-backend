package br.ueg.progweb1.lbbookstore.model.user;

import br.ueg.progweb1.lbbookstore.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Data
public class UserAuthenticated implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(Objects.equals(this.getUser().getRole().getRoleName(), UserRole.ADMIN.getRoleName()))
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_VIEWER"));

        else if(Objects.equals(this.getUser().getRole().getRoleName(), UserRole.USER.getRoleName()))
            return List.of(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_VIEWER"));

        return List.of( new SimpleGrantedAuthority("ROLE_VIEWER"));
    }

    @Override
    public String getPassword() {
        return this.getUser().getLogin().getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUser().getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
