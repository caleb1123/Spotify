package com.namphan.spotify.repository;

import com.namphan.spotify.entity.SongAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongAlbumRepository extends JpaRepository<SongAlbum,Integer> {
}
