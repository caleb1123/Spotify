package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.ListenHistoryConverter;
import com.namphan.spotify.repository.ListenHistoryRepository;
import com.namphan.spotify.model.request.MostTimesInWeekbySongId;
import com.namphan.spotify.service.ListenHistoryService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenHistoryImpl implements ListenHistoryService {
    @Autowired
    ListenHistoryRepository listenHistoryRepository;
    @Autowired
    ListenHistoryConverter listenHistoryConverter;
    @Autowired
    private ConversionService conversionService;
    @Override
    public List<MostTimesInWeekbySongId> mostTimesInWeekBySongId() {
        List<Tuple> tuples = listenHistoryRepository.MostTimesInWeekbySongId();

        return tuples.stream()
                .map(tuple -> conversionService.convert(tuple, MostTimesInWeekbySongId.class))
                .collect(Collectors.toList());
    }
}
