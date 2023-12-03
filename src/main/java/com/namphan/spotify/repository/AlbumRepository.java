package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select *\n" +
            "from albums", nativeQuery = true)
    List<Album> getAllAlbum();
}
