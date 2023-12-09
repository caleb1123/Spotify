package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    List<Category> getAllAlbum();
}
