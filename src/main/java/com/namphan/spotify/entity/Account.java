package com.namphan.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
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
    private boolean Status;

    @ManyToOne
    @JoinColumn(name = "roleId")
    @JsonIgnore
    private Role role;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Collection<Song> songs;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Collection<Album> albums;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Collection<AccountPlaylist> accountPlaylists;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Collection<Follow> followers;

    @OneToMany(mappedBy = "account1")
    @JsonIgnore
    private Collection<Follow> followings;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Collection<Order> orders;
}
