package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.AccountConverter;
import com.namphan.spotify.dto.AccountsDTO;
import com.namphan.spotify.entity.Account;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
