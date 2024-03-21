package com.namphan.spotify.converter;

import com.namphan.spotify.model.dto.ListenHistoryDTO;
import com.namphan.spotify.model.entity.ListenHistory;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.repository.PlaylistRepository;
import com.namphan.spotify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenHistoryConverter {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SongConverter songConverter;

    @Autowired
    private PlaylistConverter playlistConverter;

    @Autowired
    private AccountConverter accountConverter;

    public ListenHistory toEntity(ListenHistoryDTO listenHistoryDTO) {
        if (listenHistoryDTO == null) {
            return null;
        }

        ListenHistory entity = new ListenHistory();
        entity.setId(listenHistoryDTO.getId());
        entity.setTimestamp(listenHistoryDTO.getTimestamp());

        // Assuming songId, playlistId, and accountId are IDs only
        entity.setSong(songRepository.getReferenceById(listenHistoryDTO.getSongId()));

        entity.setPlaylist(playlistRepository.getReferenceById(listenHistoryDTO.getPlaylistId()));

        entity.setAccount(accountRepository.getReferenceById(listenHistoryDTO.getAccountId()));

        return entity;
    }

    public ListenHistoryDTO toDTO(ListenHistory listenHistory) {
        if (listenHistory == null) {
            return null;
        }

        ListenHistoryDTO dto = new ListenHistoryDTO();
        dto.setId(listenHistory.getId());
        dto.setTimestamp(listenHistory.getTimestamp());
        dto.setSongId(songConverter.toDTO(listenHistory.getSong()).getSongId());
        dto.setPlaylistId(playlistConverter.toDTO(listenHistory.getPlaylist()).getPlaylistId());
        dto.setAccountId(accountConverter.toDTO(listenHistory.getAccount()).getAccountId());

        return dto;
    }
}
