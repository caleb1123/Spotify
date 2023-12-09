package com.namphan.spotify.converter;

import com.namphan.spotify.request.MostTimesInWeekbySongId;
import jakarta.persistence.Tuple;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TupleBackedMapToMostTimesInWeekbySongIdConverter implements Converter<Tuple, MostTimesInWeekbySongId> {
    @Override
    public MostTimesInWeekbySongId convert(Tuple tuple) {
        MostTimesInWeekbySongId result = new MostTimesInWeekbySongId();
        result.setSong_id(tuple.get("song_id", Integer.class));
        result.setWeek_number(tuple.get("week_number", Integer.class));
        result.setListens_per_week(tuple.get("listens_per_week", Integer.class));
        return result;
    }
}
