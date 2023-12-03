package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    int albumId;
    String albumName;
    String description;
    String imageCover;
    String status;
    int yearRelease;
    int artistId;
    int songId;
}
