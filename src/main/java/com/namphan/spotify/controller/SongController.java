package com.namphan.spotify.controller;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.dto.SongDTO;
import com.namphan.spotify.entity.Song;
import com.namphan.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findbycategory")
    public ResponseEntity<List<SongDTO>> getAllSongsByCategory(@RequestParam int categoryId) {
        List<SongDTO> songs = songService.getAllSongbyCategory(categoryId);

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/byname")
    public ResponseEntity<SongDTO> getSongByName(@RequestParam String songName) {
        SongDTO song = songService.getbySongName(songName);

        if (song == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(song, HttpStatus.OK);
    }
}
