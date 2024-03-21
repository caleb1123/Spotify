package com.namphan.spotify.repository;

import com.namphan.spotify.model.entity.SongAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SongAlbumRepository extends JpaRepository<SongAlbum,Integer> {
}
