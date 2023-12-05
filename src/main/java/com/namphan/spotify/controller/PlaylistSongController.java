package com.namphan.spotify.controller;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.dto.PlaylistSongDTO;
import com.namphan.spotify.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/playlistsong")
public class PlaylistSongController {
    @Autowired
    PlaylistSongService playlistSongService;
    @GetMapping("/all")
    public List<PlaylistSongDTO> getAll() {
        return playlistSongService.getAll();
    }
}
