package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.AccountConverter;
import com.namphan.spotify.model.dto.AccountsDTO;
import com.namphan.spotify.model.entity.Account;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountConverter accountConverter;

    @Override
    public AccountsDTO getAccountByUserName(String userName) {
        Account account = accountRepository.getAccountByUserName(userName);
        return accountConverter.toDTO(account);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return accountRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
