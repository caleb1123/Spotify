package com.namphan.spotify.service;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.entity.Album;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AlbumService {
    List<AlbumDTO> getAllAblum();
}
