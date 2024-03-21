package com.namphan.spotify.model.dto;

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
    boolean status;
    int yearRelease;
    int artistId;
}
