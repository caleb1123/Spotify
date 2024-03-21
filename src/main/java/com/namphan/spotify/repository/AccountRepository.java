package com.namphan.spotify.repository;

import com.namphan.spotify.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT * FROM accounts WHERE user_name = :userName", nativeQuery = true)
    Optional<Account> findByUsername(@Param("userName") String username);

    @Query(value = "SELECT * FROM accounts WHERE user_name = :userName", nativeQuery = true)
    Account getAccountByUserName(@Param("userName") String userName);
}
