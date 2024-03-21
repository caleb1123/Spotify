package com.namphan.spotify.controller;

import com.namphan.spotify.model.request.MostTimesInWeekbySongId;
import com.namphan.spotify.service.ListenHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listenhistory")
public class ListenHistoryController {
    @Autowired
    ListenHistoryService listenHistoryService;
    @GetMapping("/most-listened-in-week")
    public ResponseEntity<List<MostTimesInWeekbySongId>> getMostListenedSongsInWeek() {
        List<MostTimesInWeekbySongId> mostListenedSongs = listenHistoryService.mostTimesInWeekBySongId();

        if (!mostListenedSongs.isEmpty()) {
            return ResponseEntity.ok(mostListenedSongs);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
