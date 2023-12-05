package com.namphan.spotify.controller;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.dto.SongDTO;
import com.namphan.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/all")
    public List<SongDTO> getAllAlbums() {
        return songService.getAllSong();
    }
}
