package com.mock.flight.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class SignupRequest {

    private String username;
    private String password;
    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public SignupRequest() {
    }

    public SignupRequest(String username, String password, Set<String> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
