package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
