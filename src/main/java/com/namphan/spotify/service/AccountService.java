package com.namphan.spotify.service;

import com.namphan.spotify.model.dto.AccountsDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService {
    AccountsDTO getAccountByUserName(String userName);
    UserDetailsService userDetailsService();

}
