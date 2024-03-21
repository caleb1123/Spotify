package com.namphan.spotify.repository;

import com.namphan.spotify.model.entity.AccountPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface AccountPlaylistRepository extends JpaRepository<AccountPlaylist,Integer> {
    @Query(value = "select * from account_playlist where account_id = :accountId", nativeQuery = true)
    List<AccountPlaylist> getAccountByUserName(int accountId);
}
