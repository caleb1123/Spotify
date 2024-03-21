package com.namphan.spotify.service;

import com.namphan.spotify.model.dto.AccountPlaylistDTO;

import java.util.List;

public interface AccountPlaylistService {
    List<AccountPlaylistDTO> getAllPlaylistbyAccountId(int accountId);
}
