package com.namphan.spotify.service;

import com.namphan.spotify.dto.AccountsDTO;

public interface AccountService {
    AccountsDTO getAccountByUserName(String userName);
}
