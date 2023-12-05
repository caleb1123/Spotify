package com.namphan.spotify.service;

import com.namphan.spotify.dto.PlaylistSongDTO;

import java.util.List;

public interface PlaylistSongService {
    List<PlaylistSongDTO> getAll();
}
