package com.namphan.spotify.converter;

import com.namphan.spotify.dto.AccountPlaylistDTO;
import com.namphan.spotify.entity.AccountPlaylist;
import com.namphan.spotify.repository.AccountPlaylistRepository;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountPlaylistConverter {
    @Autowired
    AccountPlaylistRepository accountPlaylistRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PlaylistRepository playlistRepository;
    public AccountPlaylistDTO toDTO(AccountPlaylist accountPlaylist) {
        if (accountPlaylist == null) {
            return null;
        }

        AccountPlaylistDTO dto = new AccountPlaylistDTO();
        dto.setId(accountPlaylist.getId());
        dto.setAccountId(accountPlaylist.getAccount().getAccountId());
        dto.setPlaylistId(accountPlaylist.getPlaylist().getPlaylistId());

        return dto;
    }

    public AccountPlaylist toEntity(AccountPlaylistDTO accountPlaylistDTO) {
        if (accountPlaylistDTO == null) {
            return null;
        }

        AccountPlaylist entity = new AccountPlaylist();
        entity.setId(accountPlaylistDTO.getId());
        // Assuming Account and Playlist entities have setId methods to set their IDs
        entity.setAccount(accountRepository.getReferenceById(accountPlaylistDTO.getAccountId()));
        entity.setPlaylist(playlistRepository.getReferenceById(accountPlaylistDTO.getPlaylistId()));


        return entity;
    }
    public List<AccountPlaylistDTO> convertToAccountPlaylistDTOList(List<AccountPlaylist> accountPlaylists) {
        List<AccountPlaylistDTO> accountPlaylistDTOList = new ArrayList<>();
        for (AccountPlaylist accountPlaylist : accountPlaylists) {
            accountPlaylistDTOList.add(toDTO(accountPlaylist));
        }
        return accountPlaylistDTOList;
    }
}
