package com.namphan.spotify.service;

import com.namphan.spotify.dto.SongDTO;

import java.util.List;

public interface SongService {
    List<SongDTO> getAllSong();
}
