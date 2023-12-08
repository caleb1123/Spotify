package com.namphan.spotify.repository;

import com.namphan.spotify.dto.ListenHistoryDTO;
import com.namphan.spotify.entity.ListenHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ListenHistoryRepository extends JpaRepository<ListenHistory,Integer> {
}
