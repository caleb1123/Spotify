package com.namphan.spotify.service;

import com.namphan.spotify.dto.SongDTO;
import com.namphan.spotify.entity.Song;

import java.util.List;

public interface SongService {
    List<SongDTO> getAllSong();
    List<SongDTO> getAllSongbyCategory(int categoryId);
    SongDTO getbySongName(String songName);
}
