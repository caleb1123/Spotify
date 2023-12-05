package com.namphan.spotify.converter;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.repository.SongRepository;
import com.namphan.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumConverter {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    AccountConverter accountConverter;

    @Autowired
    SongConverter songConverter;
    public Album toEntity(AlbumDTO albumDTO) {
        if (albumDTO == null) {
            return null;
        }

        Album entity = new Album();
        entity.setAlbumId(albumDTO.getAlbumId());
        entity.setAlbumName(albumDTO.getAlbumName());
        entity.setDescription(albumDTO.getDescription());
        entity.setImageCover(albumDTO.getImageCover());
        entity.setStatus(albumDTO.isStatus());
        entity.setYearRelease(albumDTO.getYearRelease());
        // Assuming artistId and songId are IDs only
        entity.setAccount(accountRepository.getReferenceById(albumDTO.getArtistId()));
        entity.setSong(songRepository.getReferenceById(albumDTO.getSongId()));

        return entity;
    }

    public AlbumDTO toDTO(Album album) {
        if (album == null) {
            return null;
        }

        AlbumDTO dto = new AlbumDTO();
        dto.setAlbumId(album.getAlbumId());
        dto.setAlbumName(album.getAlbumName());
        dto.setDescription(album.getDescription());
        dto.setImageCover(album.getImageCover());
        dto.setStatus(album.isStatus());
        dto.setYearRelease(album.getYearRelease());
        // Assuming artistId and songId are IDs only
        dto.setArtistId(accountConverter.toDTO(album.getAccount()).getAccountId());
        dto.setSongId(songConverter.toDTO(album.getSong()).getSongId());

        return dto;
    }
    public List<AlbumDTO> convertToAlbumDTOList(List<Album> albums) {
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (Album album : albums) {
            albumDTOList.add(toDTO(album));
        }
        return albumDTOList;
    }
}
