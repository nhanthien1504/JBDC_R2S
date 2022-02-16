//package com.mock.flight.security;
//
//
//import com.mock.flight.model.Role;
//import com.mock.flight.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
//public class UserPrincipal implements UserDetails {
//
//    private Optional<User> user;
//
//    public UserPrincipal(Optional<User> user) {
//        this.user = user;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Role> roles = user.get().getRoles();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
