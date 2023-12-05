package com.namphan.spotify.controller;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public List<AlbumDTO> getAllAlbums() {
        return albumService.getAllAblum();
    }
}
