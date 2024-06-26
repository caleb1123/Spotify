package com.namphan.spotify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "Albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @Column(columnDefinition = "nvarchar(50)")
    private String albumName;

    @Column
    private int yearRelease;

    @Column(columnDefinition = "varchar(1000)")
    private String imageCover;

    @Column(columnDefinition = "varchar(500)")
    private String description;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "artistId")

    private Account account;

    @OneToMany(mappedBy = "album")
    private Collection<SongAlbum> songAlbums;

    @OneToMany(mappedBy = "album")
    private Collection<OrderAlbum> orderAlbums;
}
