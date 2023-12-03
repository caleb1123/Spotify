package com.namphan.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Playlist_Song")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "playlistId")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "songId")
    private Song song;

}
