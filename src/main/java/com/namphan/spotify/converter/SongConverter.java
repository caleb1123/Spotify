package com.namphan.spotify.converter;

import com.namphan.spotify.model.dto.SongDTO;
import com.namphan.spotify.model.entity.Song;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongConverter {
    @Autowired
    AccountConverter accountConverter;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryConverter categoryConverter;
    public Song toEntity(SongDTO songDTO) {
        if (songDTO == null) {
            return null;
        }

        Song entity = new Song();
        entity.setSongId(songDTO.getSongId());
        entity.setSongName(songDTO.getSongName());
        entity.setImage(songDTO.getImage());
        entity.setStatus(songDTO.getStatus());
        entity.setYearRelease(songDTO.getYearRelease());
        // Assuming artistId and categoryId are IDs only
        entity.setAccount(accountRepository.getReferenceById(songDTO.getSongId()));
        entity.setCategory(categoryRepository.getReferenceById(songDTO.getCategoryId()));

        return entity;
    }

    public SongDTO toDTO(Song song) {
        if (song == null) {
            return null;
        }

        SongDTO dto = new SongDTO();
        dto.setSongId(song.getSongId());
        dto.setSongName(song.getSongName());
        dto.setImage(song.getImage());
        dto.setStatus(song.isStatus());
        dto.setYearRelease(song.getYearRelease());
        // Assuming artistId and categoryId are IDs only
        dto.setArtistId(accountConverter.toDTO(song.getAccount()).getAccountId());
        dto.setCategoryId(categoryConverter.toCategoryDTO(song.getCategory()).getCategoryId());

        return dto;
    }

    public List<SongDTO> convertToAlbumDTOList(List<Song> songs) {
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song album : songs) {
            songDTOList.add(toDTO(album));
        }
        return songDTOList;
    }
}