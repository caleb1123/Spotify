package com.namphan.spotify.service;

import com.namphan.spotify.model.dto.PlaylistSongDTO;

import java.util.List;

public interface PlaylistSongService {
    List<PlaylistSongDTO> getAll();
    List<PlaylistSongDTO> getAllbyPlaylistId(int playlistId);
}
