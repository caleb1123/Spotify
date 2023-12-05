package com.namphan.spotify.service;

import com.namphan.spotify.dto.SongAlbumDTO;

import java.util.List;

public interface SongAlbumService {
    List<SongAlbumDTO> getAll();
}
