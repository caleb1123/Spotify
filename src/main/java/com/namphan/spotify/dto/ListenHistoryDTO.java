package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListenHistoryDTO {
    private int id;
    private LocalDateTime timestamp;
    private int songId;
    private int playlistId;
    private int accountId;
}
