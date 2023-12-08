package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.SongConverter;
import com.namphan.spotify.dto.SongDTO;
import com.namphan.spotify.entity.Song;
import com.namphan.spotify.repository.SongRepository;
import com.namphan.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongImpl implements SongService {
    @Autowired
    SongConverter songConverter;

    @Autowired
    SongRepository songRepository;
    @Override
    public List<SongDTO> getAllSong() {
        List<Song> list = songRepository.getAllSong();

        return songConverter.convertToAlbumDTOList(list);
    }

    @Override
    public List<SongDTO> getAllSongbyCategory(int categoryId) {
        List<Song> song = songRepository.getAllSongbyCategory(categoryId);

        return songConverter.convertToAlbumDTOList(song);
    }

    @Override
    public SongDTO getbySongName(String songName) {
        Song song = songRepository.getSongbyName(songName);
        return songConverter.toDTO(song);
    }
}
