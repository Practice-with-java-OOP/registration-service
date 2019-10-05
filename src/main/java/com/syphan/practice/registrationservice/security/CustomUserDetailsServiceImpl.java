package com.syphan.practice.registrationservice.security;

import com.syphan.practice.commonservice.security.CustomUserDetailsService;
import com.syphan.practice.commonservice.security.UserPrincipal;
import com.syphan.practice.registrationservice.model.Role;
import com.syphan.practice.registrationservice.model.User;
import com.syphan.practice.registrationservice.repository.UserRepository;
import com.syphan.practice.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserById(Integer id) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) throw new UsernameNotFoundException("username can not be empty.");
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s %s", "User not found with username:", username));
        }
        return create(user);
    }

    private UserPrincipal create(User user) {
        Set<String> roleNameSet = new HashSet<>();
        Set<GrantedAuthority> authorities = user.getRoles().stream().map(Role::getPermissions)
                .flatMap(Collection::stream).collect(Collectors.toSet()).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getCode())).collect(Collectors.toSet());

        for (Role role : user.getRoles()) {
            roleNameSet.add(role.getCode());
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getAvatar(),
                user.getPassword(),
                roleNameSet,
                authorities
        );
    }
}
