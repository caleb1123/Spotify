package com.namphan.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account_Playlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "playlistId")
    @JsonIgnore
    private Playlist playlist;
}
