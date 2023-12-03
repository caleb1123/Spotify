package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Timer;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDTO {
    int playlistId;
    LocalDate createdAt;
    String playlistName;
    Boolean status;
}
