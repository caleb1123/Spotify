package com.namphan.spotify.controller;

import com.namphan.spotify.model.dto.PlaylistSongDTO;
import com.namphan.spotify.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/findbyplaylistid")
    public ResponseEntity<List<PlaylistSongDTO>> getAllSongsByPlaylistId(@RequestParam int playlistId) {
        List<PlaylistSongDTO> playlistSongs = playlistSongService.getAllbyPlaylistId(playlistId);

        if (playlistSongs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlistSongs, HttpStatus.OK);
    }
}
