package com.namphan.spotify.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MostTimesInWeekbySongId {
    int song_id;
    int week_number;
    int listens_per_week;
}
