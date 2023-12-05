package com.namphan.spotify.converter;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.dto.PlaylistSongDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.PlaylistSong;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.repository.PlaylistRepository;
import com.namphan.spotify.repository.PlaylistSongRepository;
import com.namphan.spotify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaylistSongConverter {
    @Autowired
    PlaylistConverter playlistConverter;

    @Autowired
    SongConverter songConverter;

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    SongRepository songRepository;

    public PlaylistSongDTO toDTO(PlaylistSong playlistSong) {
        if (playlistSong == null) {
            return null;
        }

        PlaylistSongDTO dto = new PlaylistSongDTO();
        dto.setId(playlistSong.getId());
        dto.setPlaylistId(playlistSong.getPlaylist().getPlaylistId());
        dto.setSongId(playlistSong.getSong().getSongId());

        return dto;
    }

    public PlaylistSong toEntity(PlaylistSongDTO playlistSongDTO) {
        if (playlistSongDTO == null) {
            return null;
        }

        PlaylistSong entity = new PlaylistSong();
        entity.setId(playlistSongDTO.getId());
        // Assuming IDs are present in DTO for playlist and song
        entity.setPlaylist(playlistRepository.getReferenceById(playlistSongDTO.getPlaylistId()));
        entity.setSong(songRepository.getReferenceById(playlistSongDTO.getSongId()));

        return entity;
    }

    public List<PlaylistSongDTO> convertToPlaylistSongDTOList(List<PlaylistSong> playlistSongs) {
        List<PlaylistSongDTO> playlistSongDTOList = new ArrayList<>();
        for (PlaylistSong playlistSong : playlistSongs) {
            playlistSongDTOList.add(toDTO(playlistSong));
        }
        return playlistSongDTOList;
    }
}
