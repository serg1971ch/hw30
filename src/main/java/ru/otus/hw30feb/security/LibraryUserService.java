package ru.otus.hw30feb.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
        GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ADMIN");
        if("user".equals(username)) {
            return new User("user", "1234", List.of(userAuthority));
        }

        if ("admin".equals(username)) {
            return new User("admin", "admin", List.of(adminAuthority));
        }
        throw new UsernameNotFoundException("user не найден");
    }
}
