package com.namphan.spotify.service.impl;

import com.namphan.spotify.dto.SongAlbumDTO;
import com.namphan.spotify.entity.SongAlbum;
import com.namphan.spotify.repository.SongAlbumRepository;
import com.namphan.spotify.service.SongAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongAlbumImpl implements SongAlbumService {
    @Autowired
    SongAlbumRepository songAlbumRepository;

    @Override
    public List<SongAlbumDTO> getAll() {
        return null;
    }
}
