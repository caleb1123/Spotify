package com.namphan.spotify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongAlbumDTO {
    int id;
    int albumId;
    int songId;
}
