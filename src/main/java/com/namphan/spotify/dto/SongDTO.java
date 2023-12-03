package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    int songId;
    String songName;
    String image;
    Boolean status;
    int yearRelease;
    int artistId;
    int categoryId;
}
