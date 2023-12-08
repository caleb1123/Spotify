package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.PlaylistConverter;
import com.namphan.spotify.converter.PlaylistSongConverter;
import com.namphan.spotify.dto.PlaylistSongDTO;
import com.namphan.spotify.entity.PlaylistSong;
import com.namphan.spotify.repository.PlaylistSongRepository;
import com.namphan.spotify.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaylistSongImpl implements PlaylistSongService {
    @Autowired
    PlaylistSongRepository playlistSongRepository;
    @Autowired
    PlaylistSongConverter songConverter;
    @Autowired
    PlaylistSongConverter playlistSongConverter;
    @Override
    public List<PlaylistSongDTO> getAll() {
        List<PlaylistSong> playlistSongs = playlistSongRepository.getAll();
        return playlistSongConverter.convertToPlaylistSongDTOList(playlistSongs);
    }

    @Override
    public List<PlaylistSongDTO> getAllbyPlaylistId(int playlistId) {
        List<PlaylistSong> playlistSong = playlistSongRepository.getAllByPlaylistId(playlistId);

        return playlistSongConverter.convertToPlaylistSongDTOList(playlistSong);
    }
}
