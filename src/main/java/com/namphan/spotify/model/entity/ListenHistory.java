package com.namphan.spotify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ListenHistory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListenHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
