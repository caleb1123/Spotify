package com.namphan.spotify.controller;

import com.namphan.spotify.dto.AccountPlaylistDTO;
import com.namphan.spotify.entity.AccountPlaylist;
import com.namphan.spotify.service.AccountPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountplaylist")
public class AccountPlaylistController {
    @Autowired
    AccountPlaylistService accountPlaylistService;
    @GetMapping("/account") // Endpoint to get playlists by accountId using request parameter
    public ResponseEntity<List<AccountPlaylistDTO>> getAllPlaylistsByAccountId(@RequestParam int accountId) {
        List<AccountPlaylistDTO> accountPlaylists = accountPlaylistService.getAllPlaylistbyAccountId(accountId);
        if(accountPlaylists.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(accountPlaylists, HttpStatus.OK);
        }

    }
}
