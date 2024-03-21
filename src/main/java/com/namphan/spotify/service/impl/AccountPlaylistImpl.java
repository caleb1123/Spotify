package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.AccountPlaylistConverter;
import com.namphan.spotify.model.dto.AccountPlaylistDTO;
import com.namphan.spotify.model.entity.AccountPlaylist;
import com.namphan.spotify.repository.AccountPlaylistRepository;
import com.namphan.spotify.service.AccountPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPlaylistImpl implements AccountPlaylistService {
    @Autowired
    AccountPlaylistRepository accountPlaylistRepository;
    @Autowired
    AccountPlaylistConverter accountPlaylistConverter;
    @Override
    public List<AccountPlaylistDTO> getAllPlaylistbyAccountId(int accountId) {
        List<AccountPlaylist> accountPlaylists = accountPlaylistRepository.getAccountByUserName(accountId);
        return accountPlaylistConverter.convertToAccountPlaylistDTOList(accountPlaylists);
    }
}
