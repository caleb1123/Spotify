package com.namphan.spotify.repository;

import com.namphan.spotify.model.entity.PlaylistSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PlaylistSongRepository extends JpaRepository<PlaylistSong,Integer> {
    @Query(value = "select *\n" +
            "from playlist_song", nativeQuery = true)
    List<PlaylistSong> getAll();

    @Query(value = "select * from playlist_song where playlist_id = :playlistId\n",nativeQuery = true)
    List<PlaylistSong> getAllByPlaylistId(int playlistId);

}
