package com.namphan.spotify.repository;

import com.namphan.spotify.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUserName(String userName);
    Account findUserByEmail(String email);
    @Query(value = "SELECT * FROM accounts WHERE user_name = :userName AND password = :password", nativeQuery = true)
    Account findAccountByUserNameAndPassword(String userName,String password);
}
