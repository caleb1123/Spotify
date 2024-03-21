package com.namphan.spotify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Playlists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistId;

    @Column(columnDefinition = "varchar(50)")
    private String playlistName;

    @Column
    private LocalDate createdAt;

    @Column
    private boolean status;

    @OneToMany(mappedBy = "playlist")
    private Collection<AccountPlaylist> accountPlaylists;

    @OneToMany(mappedBy = "playlist")
    private Collection<PlaylistSong> playlistSongs;
    @OneToMany(mappedBy = "playlist")
    private Collection<ListenHistory> listenHistories;
}
