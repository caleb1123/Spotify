package com.namphan.spotify.service;

import com.namphan.spotify.model.request.MostTimesInWeekbySongId;

import java.util.List;

public interface ListenHistoryService {
    List<MostTimesInWeekbySongId> mostTimesInWeekBySongId();
}
