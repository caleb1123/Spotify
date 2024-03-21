package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.AlbumConverter;
import com.namphan.spotify.model.dto.AlbumDTO;
import com.namphan.spotify.model.entity.Album;
import com.namphan.spotify.repository.AlbumRepository;
import com.namphan.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumImpl implements AlbumService {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    AlbumConverter albumConverter;

    @Override
    public List<AlbumDTO> getAllAblum() {
        List<Album> list = albumRepository.getAllAlbum();

        return albumConverter.convertToAlbumDTOList(list);
    }
}
