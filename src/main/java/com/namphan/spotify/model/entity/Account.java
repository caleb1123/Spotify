package com.namphan.spotify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountId;

    @Column(unique = true,columnDefinition = "varchar(50)")
    private String userName;

    @Column(unique = true,columnDefinition = "varchar(50)")
    private String email;

    @Column
    private String password;

    @Column(columnDefinition = "nvarchar(50)")
    private String name;

    @Column(unique = true,columnDefinition = "varchar(50)")
    private String phone;

    @Column
    private LocalDate dob;

    @Column
    private String linkSocial;

    @Column
    private String linkSocial2;

    @Column
    private boolean status;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @OneToMany(mappedBy = "account")
    private Collection<Song> songs;

    @OneToMany(mappedBy = "account")

    private Collection<Album> albums;

    @OneToMany(mappedBy = "account")
    private Collection<AccountPlaylist> accountPlaylists;

    @OneToMany(mappedBy = "account")
    private Collection<Follow> followers;

    @OneToMany(mappedBy = "account1")
    private Collection<Follow> followings;

    @OneToMany(mappedBy = "account")
    private Collection<Order> orders;

    @OneToMany(mappedBy = "account")
    private Collection<ListenHistory> listenHistories;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return userName;
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
        return status;
    }
}
