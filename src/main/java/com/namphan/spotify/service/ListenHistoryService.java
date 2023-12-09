package com.namphan.spotify.service;

import com.namphan.spotify.request.MostTimesInWeekbySongId;

import java.util.List;

public interface ListenHistoryService {
    List<MostTimesInWeekbySongId> mostTimesInWeekBySongId();
}
