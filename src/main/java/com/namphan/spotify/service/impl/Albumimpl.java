package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.AlbumConverter;
import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.repository.AlbumRepository;
import com.namphan.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Albumimpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumConverter albumConverter;
    @Autowired
    public Albumimpl(AlbumRepository albumRepository, AlbumConverter albumConverter) {
        this.albumRepository = albumRepository;
        this.albumConverter = albumConverter;
    }


    @Override
    public List<AlbumDTO> getAllAblum() {
        List<Album> list = albumRepository.getAllAlbum();

        return albumConverter.convertToAlbumDTOList(list);
    }
}
