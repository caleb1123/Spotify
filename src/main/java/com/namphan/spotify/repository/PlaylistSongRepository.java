package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.PlaylistSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistSongRepository extends JpaRepository<PlaylistSong,Integer> {
    @Query(value = "select *\n" +
            "from playlist_song", nativeQuery = true)
    List<PlaylistSong> getAll();

}
