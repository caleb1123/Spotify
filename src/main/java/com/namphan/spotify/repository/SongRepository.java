package com.namphan.spotify.repository;

import com.namphan.spotify.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SongRepository extends JpaRepository<Song, Integer> {
    @Query(value = "select * from songs", nativeQuery = true)
    List<Song> getAllSong();
    @Query(value = "select * from songs where category_id = :categoryId", nativeQuery = true)
    List<Song> getAllSongbyCategory(int categoryId);
    @Query(value = "select * from songs where song_name = :songName",nativeQuery = true)
    Song getSongbyName(String songName);
}
