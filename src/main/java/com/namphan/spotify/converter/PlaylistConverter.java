package com.namphan.spotify.converter;

import com.namphan.spotify.model.dto.PlaylistDTO;
import com.namphan.spotify.model.entity.Playlist;
import org.springframework.stereotype.Component;

@Component
public class PlaylistConverter {
    public PlaylistDTO toDTO(Playlist playlist) {
        if (playlist == null) {
            return null;
        }

        PlaylistDTO dto = new PlaylistDTO();
        dto.setPlaylistId(playlist.getPlaylistId());
        dto.setPlaylistName(playlist.getPlaylistName());
        dto.setCreatedAt(playlist.getCreatedAt());
        dto.setStatus(playlist.isStatus());

        return dto;
    }

    public Playlist toEntity(PlaylistDTO playlistDTO) {
        if (playlistDTO == null) {
            return null;
        }

        Playlist entity = new Playlist();
        entity.setPlaylistId(playlistDTO.getPlaylistId());
        entity.setPlaylistName(playlistDTO.getPlaylistName());
        entity.setCreatedAt(playlistDTO.getCreatedAt());
        entity.setStatus(playlistDTO.getStatus());

        return entity;
    }
}
