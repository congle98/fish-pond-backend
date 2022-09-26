package com.fishpond.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fishpond.sercurityUtils.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private boolean status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authoritySet = new HashSet<>();
        authoritySet.add(new Authority(this.role));
        return authoritySet;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
