package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SongRepository extends JpaRepository<Song, Integer> {
}
